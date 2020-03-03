package main.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public  Connection connect() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        //com.mysql.jdbc.Driver s; //it is the easyest way to implement dependency

        String url = "jdbc:mysql://localhost:3306/new_schema";
        String username="root";
        String password="root";

        Connection conn = DriverManager.getConnection(url, username,password);

        return conn;
    }
}
