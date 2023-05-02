package com.iecsc.iecsccontrole.Services;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import javafx.scene.control.*;


import java.time.LocalDate;


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
            membroDTO.setEstadoCivil(estadoCivilValue);
            membroDTO.setDataNascimento(dateBirthLocalDate.toString());

            membroDAO.insertMembro(membroDTO);

            nameText.setText(null);
            birthDateText.setValue(null);

            alertUTIL.showAlert(Alert.AlertType.INFORMATION,"SUCESSO", membroDTO.toString());

        }catch (Exception err){
            alertUTIL.showAlert(Alert.AlertType.ERROR,"FALHA", err.toString());
        }
    }
}
