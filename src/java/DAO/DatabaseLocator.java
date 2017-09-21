/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Automateasy
 */
public class DatabaseLocator {
    private static DatabaseLocator instance = new DatabaseLocator();

    public static DatabaseLocator getInstance(){
        return instance;
    }
    
    private DatabaseLocator() {}
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\virtual_shop_db");
        return conn;
    }
}
