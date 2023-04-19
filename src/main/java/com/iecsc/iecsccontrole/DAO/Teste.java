package com.iecsc.iecsccontrole.DAO;

import com.iecsc.iecsccontrole.DTO.MembroDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public void testarConnection(){
        ResultSet rs;
        try{
            List<MembroDTO> listMembro = new ArrayList<>();

            MembroDAO membrodao = new MembroDAO();
            rs = membrodao.membroTest();
            while(rs.next()){
                MembroDTO membrodto = new MembroDTO();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    membrodto.setName(rs.getString(1));
                    listMembro.add(membrodto);
                }
            }
            for (MembroDTO dto : listMembro){
                System.out.println(dto.getName());
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
