package com.iecsc.iecsccontrole.Services;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import javafx.scene.control.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MembroService {

    public void insertMembro(DatePicker birthDateText, TextField nameText, ToggleGroup estadoCivil){
        AlertUTIL alertUTIL = new AlertUTIL();
        try{
            MembroDTO membroDTO = new MembroDTO();
            MembroDAO membroDAO = new MembroDAO();

            RadioButton estadoCivilRadioButton = (RadioButton) estadoCivil.getSelectedToggle();
            String estadoCivilValue = estadoCivilRadioButton.getText();
            LocalDate dateBirthLocalDate = birthDateText.getValue();

            membroDTO.setName(nameText.getText());
            membroDTO.setEstado_civil(estadoCivilValue);
            membroDTO.setData_nascimento(dateBirthLocalDate.toString());

            membroDAO.insertMembro(membroDTO);

            nameText.setText(null);
            birthDateText.setValue(null);

            alertUTIL.showAlert(Alert.AlertType.INFORMATION,"SUCESSO", membroDTO.toString());

        }catch (Exception err){
            alertUTIL.showAlert(Alert.AlertType.ERROR,"FALHA", err.toString());
        }
    }

    public List<MembroDTO> getAllMembros(){
        ResultSet rs;
        try{
            List<MembroDTO> listMembro = new ArrayList<>();

            MembroDAO membrodao = new MembroDAO();
            rs = membrodao.getAllMembros();
            while(rs.next()){
                MembroDTO membrodto = new MembroDTO();
                membrodto.setName(rs.getString(1));
                membrodto.setEstado_civil(rs.getString(2));
                membrodto.setData_nascimento(rs.getString(3));
                listMembro.add(membrodto);
            }
            return listMembro;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
