package com.iecsc.iecsccontrole.DAO;

import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.DTO.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ResultSet insertRegister(RegisterDTO registerDTO){
        con = new DBConnection().connectDAO();
        String sql = "INSERT INTO registros(valor, tipo_registro) VALUES (?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, registerDTO.getValue());
            ps.setString(2, registerDTO.getRegisterType());
            ps.executeUpdate();
            con.close();
            return rs;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
