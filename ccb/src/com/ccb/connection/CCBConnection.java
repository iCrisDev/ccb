package com.ccb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Cristopher Alejandro Campuzano Flores <cristopher8295@outlook.com>
 */
public class CCBConnection {
    
    private Connection connection;
    
    private String database, userDB, passwordDB;
    
    public CCBConnection(){
        database = "ciberClub";
        userDB = "root";
        passwordDB = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+database,userDB,passwordDB);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
