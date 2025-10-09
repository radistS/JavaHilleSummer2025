import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName ="hillel"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "rootroot"; // password

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // create DB
        // create connectivity to DB ([java app -> jdbc] -> DB)
        // jdbc url + login + pass

        //  statment and prepared statment

        // MySQL DB connectivity configuration
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL( false );
        dataSource.setServerTimezone( serverTimeZone );
        dataSource.setServerName( serverName );
        dataSource.setDatabaseName( databaseName );
        dataSource.setPortNumber( portNumber );
        dataSource.setUser( user );
        dataSource.setPassword( password );


        //Create connection to DB
        Connection connection =  dataSource.getConnection();

        String SQL = """
                create table if not exists hillel.empl(
                    first_name varchar(255) not null,
                    last_name  varchar(255) not null
                    );""";

        // Create table using SQL query
        Statement statement = connection.createStatement();
        statement.execute(SQL);

        //Add user Ivan Ivanov
        statement.execute("insert into empl (first_name, last_name) value  ('Ivan', 'Ivanov');");

        // add prepared Statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into  empl (first_name, last_name) value  (?, ?);");
        List<String> users = List.of("user 1", "user 2", "user 3", "user 4");
        for (String u : users) {
            preparedStatement.setString(1, u);
            preparedStatement.setString(2, u);
            preparedStatement.executeUpdate();
        }

        // select: get data from DB by SQL query about table structure
        ResultSet rs = statement.executeQuery("select * from empl");

        String leter = "B";

//        ResultSet rs = statement.executeQuery("SELECT * from empl where empl.first_name like '"+ leter+ "%'");

        // meta data - table structure
//        System.out.println("Table name : " + rs.getMetaData().getTableName(2)); //true
//        System.out.println("------------");
//        int columnCount = rs.getMetaData().getColumnCount();
//        for (int i = 1; i <= columnCount; i++) {
//            System.out.print("column name : " + rs.getMetaData().getColumnName(i) + ", ");
//            System.out.print("column size : " + rs.getMetaData().getColumnDisplaySize(i) + ", ");
//            System.out.println("column type : " + rs.getMetaData().getColumnTypeName(i));
//        }
////
        // get data from table and mapping
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
//            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            student.add(new Student(firstName, lastName));
        }
        System.out.println(student.size());
        System.out.println("----------");

        for (Student s : student)
            System.out.println(s);;

        // close connection
        connection.close();
    }
}
