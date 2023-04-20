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
    MembroDTO membroDTO;

    public ResultSet membroTest(){
        con = new DBConnection().connectDAO();
        String  sql = "SELECT * FROM membros";
        try {
            ps = con.prepareStatement(sql);
            //ps.setString(1, membroDTO.getName());
            rs = ps.executeQuery();
            con.close();
            return rs;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    public ResultSet insertMembro(MembroDTO membroDTO){
        con = new DBConnection().connectDAO();
        String sql = "INSERT INTO membros(name, estado_civil, data_nascimento) VALUES (?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, membroDTO.getName());
            ps.setString(2, membroDTO.getEstadoCivil());
            ps.setString(3, membroDTO.getDataNascimento());
            ps.executeUpdate();
            con.close();
            return rs;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
