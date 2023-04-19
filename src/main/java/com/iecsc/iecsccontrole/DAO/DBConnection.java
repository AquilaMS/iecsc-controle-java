package com.iecsc.iecsccontrole.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection con = null;

    public Connection connectDAO(){
        try{
            String url = "jdbc:sqlite:C:\\iecsc-db\\java-sqlite\\java-sqlite-iecsc";
            con = DriverManager.getConnection(url);
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return con;
    }
}
