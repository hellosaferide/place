package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final String URL="jdbc:mysql://127.0.0.1:3306/place?&useSSL=false";
    public static final String USERNAME="root";
    public static final String PASSWORD="14250369xmh9";
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
