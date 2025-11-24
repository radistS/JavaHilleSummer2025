# Міні система мікросервісів Spring Cloud

## Склад
- Eureka Discovery Server (порт 8761)
- API Gateway (порт 8080)
- User Service (порт 9001)
- Order Service (порт 9002) викликає User Service через Feign

## Вимоги
Spring Boot 3.3.x, Spring Cloud 2023.x, Java 17, Maven

## Запуск сервісів (один інстанс кожного)
Кожен сервіс — окремий Maven-проєкт. Запускайте в окремих терміналах у такому порядку: eureka → user → order → gateway.

```bash
# 1. Запуск Eureka Server
cd eureka-server
mvn spring-boot:run

# 2. Запуск User Service (новий термінал)
cd user-service
mvn spring-boot:run

# 3. Запуск Order Service (новий термінал)
cd order-service
mvn spring-boot:run

# 4. Запуск API Gateway (новий термінал)
cd api-gateway
mvn spring-boot:run
```

Після запуску зачекайте 3–5 секунд, поки сервіси зареєструються в Eureka.

## Опціонально: запуск кількох інстансів
Скрипт `run-multiple-instances.sh` може стартувати один інстанс (за замовчуванням) або кілька — якщо додати прапорець `--multiple`.

```bash
# Один інстанс (Eureka, Gateway, user-service:9001, order-service:9002)
./run-multiple-instances.sh

# Кілька інстансів (user-service: 9001, 9003, 9004; order-service: 9002, 9005)
./run-multiple-instances.sh --multiple

# Перевірка реєстрації / базової балансизації (додатково)
./run-multiple-instances.sh --multiple --check
```

Логи створюються у каталозі `logs/`.

## Перевірка роботи
1. Відкрийте панель Eureka: http://localhost:8761 — повинні з'явитися `USER-SERVICE`, `ORDER-SERVICE`, `API-GATEWAY`.
2. Запит користувача через шлюз:
   ```bash
   curl http://localhost:8080/users/1
   ```
   Очікувано:
   ```json
   {"id":1,"name":"User-1"}
   ```
3. Запит замовлення через шлюз:
   ```bash
   curl http://localhost:8080/orders/1
   ```
   Очікувано (приклад):
   ```json
   {"orderId":1,"product":"Laptop","user":{"id":1,"name":"User-1"}}
   ```

## Перевірка стану (Health / Actuator)
```bash
# Eureka Server
curl http://localhost:8761/actuator/health

# API Gateway
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/gateway/routes

# User Service
curl http://localhost:9001/actuator/health

# Order Service
curl http://localhost:9002/actuator/health
```

## Помилки та діагностика
- 503 SERVICE_UNAVAILABLE через gateway: сервіс ще не зареєстрований або не працює.
- 404 NOT_FOUND: перевірте шлях (`/users/1` замість `/user/1`, `/orders/1` замість `/order/1`).
- Якщо відповідь повільна: перевірте логи у `logs/` та стан Eureka.

## Зупинка процесів
У кожному терміналі натисніть Ctrl+C або:
```bash
pkill -f user-service-1.0-SNAPSHOT.jar
pkill -f order-service-1.0-SNAPSHOT.jar
pkill -f api-gateway-1.0-SNAPSHOT.jar
pkill -f eureka-server-1.0-SNAPSHOT.jar
```

## Структура каталогів
```
./eureka-server
./api-gateway
./user-service
./order-service
```

## Логування
В API Gateway доданий глобальний фільтр логування запитів (метод, URI, заголовки, статус, тривалість). Рівні логування налаштовані в `api-gateway/src/main/resources/application.yml`.

## Балансування
Спеціальний кастомний LoadBalancer видалено — використовується стандартний RoundRobin `spring-cloud-loadbalancer`. Для спостереження за розподілом запитів у режимі `--multiple` варто додати у відповіді сервісів порт або instance-id (можна розширити DTO).

## Додатково / Покращення (опціонально)
- Docker Compose для спільного запуску
- Resilience4j для fallback при недоступності User Service
- Агрегуючий кореневий `pom.xml` для одночасної збірки всіх модулів
- Виведення `instanceId` у REST-відповідях для явного моніторингу балансування

Додавайте скріншот панелі Eureka у репозиторій (наприклад `eureka-dashboard.png`) за потреби.
