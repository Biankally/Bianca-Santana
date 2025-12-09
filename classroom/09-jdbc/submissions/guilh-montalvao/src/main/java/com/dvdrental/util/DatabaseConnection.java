package com.dvdrental.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo db.properties: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
        );
    }
}
