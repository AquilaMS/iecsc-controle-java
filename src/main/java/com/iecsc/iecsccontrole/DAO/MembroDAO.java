package com.iecsc.iecsccontrole.DAO;

import com.iecsc.iecsccontrole.DTO.MembroDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembroDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ResultSet membroTest(){
        con = new DBConnection().connectDAO();
        String  sql = "SELECT * FROM membros";
        try {
            ps = con.prepareStatement(sql);
            //ps.setString(1, membroDTO.getName());
            rs = ps.executeQuery();
            return rs;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
