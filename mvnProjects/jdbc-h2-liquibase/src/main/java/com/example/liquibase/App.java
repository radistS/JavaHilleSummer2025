package com.example.liquibase;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.Contexts;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Один и тот же URL используется для Liquibase и JDBC
        String url  = "jdbc:h2:mem:lb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        // 1) Применяем миграции Liquibase ПРОГРАММНО к этой же in-memory БД
        Database database = DatabaseFactory.getInstance()
                .openDatabase(url, user, pass, null, new ClassLoaderResourceAccessor());
        Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.xml",
                new ClassLoaderResourceAccessor(), database);
        liquibase.update(new Contexts()); // apply all changesets
        database.close(); // закрываем обертку Liquibase (сама БД жива из-за DB_CLOSE_DELAY=-1)

        // 2) Работаем обычным JDBC — читаем данные
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("\nUsers after migrations:");
            try (PreparedStatement ps = conn.prepareStatement("select id, username, email, created_at from users order by id");
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("id=%d, username=%s, email=%s, created_at=%s%n",
                            rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getTimestamp("created_at"));
                }
            }

            // Вставим зачисление
            try (PreparedStatement ins = conn.prepareStatement(
                    "insert into enrollments(user_id, course_id, grade, enrolled_at) values(?, ?, ?, CURRENT_TIMESTAMP)")) {
                ins.setLong(1, 1L); // alice
                ins.setLong(2, 2L); // CS-101
                ins.setString(3, "A");
                ins.executeUpdate();
            }

            System.out.println("\nEnrollments:");
            try (PreparedStatement ps = conn.prepareStatement(
                    "select e.id, u.username, c.code, e.grade, e.enrolled_at " +
                            "from enrollments e join users u on u.id=e.user_id join courses c on c.id=e.course_id order by e.id");
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("id=%d, user=%s, course=%s, grade=%s, at=%s%n",
                            rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
                }
            }
        }
    }
}
