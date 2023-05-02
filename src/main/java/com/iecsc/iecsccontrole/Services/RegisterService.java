package com.iecsc.iecsccontrole.Services;

import com.iecsc.iecsccontrole.DAO.RegisterDAO;
import com.iecsc.iecsccontrole.DTO.RegisterDTO;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RegisterService {

    public void insertRegister(TextField insertValueTextField, TextField insertRegisterTypeRegisterField){
        AlertUTIL alertUTIL = new AlertUTIL();
        try{
            RegisterDAO registerDAO = new RegisterDAO();
            RegisterDTO registerDTO = new RegisterDTO();

            registerDTO.setRegisterType(insertRegisterTypeRegisterField.getText());
            registerDTO.setValue(insertValueTextField.getText());
            registerDAO.insertRegister(registerDTO);

            insertRegisterTypeRegisterField.setText("");
            insertValueTextField.setText("");

            alertUTIL.showAlert(Alert.AlertType.INFORMATION,"SUCESSO", registerDTO.toString());

        }catch (Exception err){
            System.out.println(err.getMessage());
            alertUTIL.showAlert(Alert.AlertType.ERROR,"FALHA", err.toString());
        }
    }
}
