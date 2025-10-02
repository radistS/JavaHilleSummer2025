package com.hilllel.cw_25.solid;

public class DiPr {

}

// Принцип інверсії залежностей: Модулі високого рівня не повинні залежати від модулів низького рівня.
// Обидва повинні залежати від абстракцій (інтерфейсів).

// Інтерфейс Database - абстракція, від якої залежатимуть всі модулі
interface Database {
    void save(String data);
}

// Клас, який реалізує збереження в MySQL
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Збереження даних в MySQL: " + data);
    }
}

// Високорівневий модуль, який залежить від абстракції Database, а не від конкретної реалізації
class Application {
//    private Database database;
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void saveData(String data) {
        database.save(data);  // Виклик методу через інтерфейс Database
    }
}

// Пояснення:
// Замість залежності від конкретної реалізації бази даних (наприклад, MySQL),
// клас Application залежить від абстракції (інтерфейсу Database), що дозволяє легко змінювати реалізацію.
