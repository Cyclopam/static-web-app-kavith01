package com.dxc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL=
            "jdbc:sqlserver://locahost:1433;databaseName=ContactDB;encrypt=true;trustServerCertificate=true";
    private static final String USER="sa";
    private static final String PASSWORD="password";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL,USER,PASSWORD);

    }

}
