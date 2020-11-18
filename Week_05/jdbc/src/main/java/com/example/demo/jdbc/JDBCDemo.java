package com.example.demo.jdbc;

import java.sql.*;

public class JDBCDemo {

    private static final String DRIVER_CLASS = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/demo";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(DRIVER_CLASS);
        //加载驱动
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        statement.execute("DROP TABLE IF EXISTS FOO");
        statement.execute("CREATE TABLE FOO(ID NUMERIC PRIMARY KEY , NAME VARCHAR(20) ) ");
        statement.execute("INSERT INTO foo VALUES (1, 'BAR1')");
        statement.execute("INSERT INTO foo VALUES (2, 'BAR2')");

        showFoo(statement);

        statement.execute("UPDATE FOO SET NAME = 'BAR3' WHERE ID = 1 ");

        showFoo(statement);

        statement.execute("DELETE FOO WHERE ID = 1 ");

        showFoo(statement);

        statement.close();
        connection.close();

    }

    private static void showFoo(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM FOO");
        while (rs.next()) {
            System.out.println("ID:" + rs.getInt("ID") + "\tNAME:" + rs.getString("NAME"));
        }
        System.out.println(" ------------------------------------ ");
    }

}
