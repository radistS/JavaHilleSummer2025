# H2 + Liquibase (in-memory) — Demo

**Цель:** показать, как программно запускать миграции Liquibase против in‑memory H2 и затем работать с БД через JDBC в той же JVM.

## Запуск
```bash
mvn -q -DskipTests package
mvn -q exec:java
```

## Что внутри
- `liquibase-core` и H2 (in‑memory `jdbc:h2:mem:liquibase_demo;DB_CLOSE_DELAY=-1`)
- Changelog:
  - `01-create-users.xml` — таблица `users`, тестовые данные, индекс
  - `02-create-courses-and-enrollments.xml` — `courses`, `enrollments`, FK и данные
- `App.java`:
  1. Применяет Liquibase миграции **программно** к той же БД
  2. Делает выборки/вставки через JDBC
