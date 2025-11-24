#!/usr/bin/env bash
# Load balancing / registration check. Requires Eureka + services running.
# Usage: ./scripts/check-loadbalancing.sh [--raw]
# Optional env vars: EUREKA, GATEWAY, USER_APP, ORDER_APP

set -e
# Don't use -u to avoid unbound variable error when parsing empty values.

RAW=false
while [[ $# -gt 0 ]]; do
  case "$1" in
    --raw) RAW=true; shift;;
    *) echo "Unknown arg: $1"; shift;;
  esac
done

EUREKA=${EUREKA:-http://localhost:8761}
GATEWAY=${GATEWAY:-http://localhost:8080}
USER_APP=${USER_APP:-USER-SERVICE}
ORDER_APP=${ORDER_APP:-ORDER-SERVICE}

echo "Checking Eureka at $EUREKA" >&2

fetch_app_json() {
  local app=$1
  curl -s -H "Accept: application/json" "$EUREKA/eureka/apps/$app" || true
}

count_instances() {
  local json="$1"
  python3 - <<PY 2>/dev/null || echo 0
import json,sys
try:
    data=json.loads(sys.stdin.read())
    app=data.get('application')
    if not app:
        print(0)
    else:
        inst=app.get('instance')
        if isinstance(inst,list):
            print(len(inst))
        elif isinstance(inst,dict):
            print(1)
        else:
            print(0)
except Exception:
    print(0)
PY
}

report_instances() {
  local app=$1
  local json
  json=$(fetch_app_json "$app")
  if [[ -z "$json" ]]; then
    echo "Checking instances for $app... no response" >&2
    echo 0
    return
  fi
  [[ "$RAW" == true ]] && echo "Raw $app JSON: $json" >&2
  local c
  c=$(count_instances "$json")
  echo "Checking instances for $app... $c" >&2
  echo "$c"
}

user_count=$(report_instances "$USER_APP")
order_count=$(report_instances "$ORDER_APP")

echo "USER-SERVICE instances: $user_count" >&2
echo "ORDER-SERVICE instances: $order_count" >&2

# Ensure numeric comparisons (default to 0 if empty)
user_count=${user_count:-0}
order_count=${order_count:-0}

if [[ $user_count -lt 1 || $order_count -lt 1 ]]; then
  echo "ERROR: Не зареєстровано мінімальний набір інстансів (user/order)." >&2
  exit 1
fi

if [[ $user_count -lt 2 || $order_count -lt 2 ]]; then
  echo "(Для балансування бажано >=2 інстанси кожного сервісу)" >&2
fi

echo "Test request to user-service via gateway:" >&2
HTTP_CODE=$(curl -s -o /dev/null -w '%{http_code}' "$GATEWAY/users/1")
echo "GET $GATEWAY/users/1 -> HTTP $HTTP_CODE" >&2
if [[ "$HTTP_CODE" != "200" ]]; then
  echo "Попередження: очікувалась 200, отримано $HTTP_CODE. Перевірте логи gateway та чи запущено user-service." >&2
fi

echo "Done." >&2
