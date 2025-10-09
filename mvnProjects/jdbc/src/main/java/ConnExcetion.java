import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnExcetion {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        for (int i = 0; i < 10000; i++){
            System.out.println(i);
            // create connection to DB
            Class.forName("com.mysql.cj.jdbc.Driver"); // driver registration
            Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hillel?"
                    + "useSSL=false&user=root&password=rootroot&serverTimezone=UTC");

//            connection.close();
        }

        System.out.println();
    }
}
