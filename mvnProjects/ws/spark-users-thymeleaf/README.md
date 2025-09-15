# Spark Users + Thymeleaf (CRUD + CSV)

A minimal SparkJava app with Thymeleaf UI:
- List users as a table (id / firstName / lastName / email)
- View, add, edit, delete users
- Upload users from CSV (header may include: id, firstName, lastName, email)

## Requirements
- Java 17+
- Maven 3.8+

## Run (dev)
```bash
mvn -q clean compile exec:java
# open http://localhost:4567/ui/users
```

## Build runnable jar
```bash
mvn -q -DskipTests package
java -jar target/spark-users-thymeleaf-1.0.0-shaded.jar
```

## CSV example
```
firstName,lastName,email
Ada,Lovelace,ada@example.com
Alan,Turing,alan@example.com
```
