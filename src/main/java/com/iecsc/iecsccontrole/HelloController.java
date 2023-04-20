package com.iecsc.iecsccontrole;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DAO.Teste;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameTextField;

    @FXML
    private ToggleGroup estadoCivil;

    @FXML
    private DatePicker birthDateTextField;

    @FXML
    protected void  onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Teste teste = new Teste();
        teste.testarConnection();
    }

    @FXML
    protected void onInsertMembro(){
        try{
            MembroDTO membroDTO = new MembroDTO();
            MembroDAO membroDAO = new MembroDAO();

            RadioButton estadoCivilRadioButton = (RadioButton) estadoCivil.getSelectedToggle();
            String estadoCivilValue = estadoCivilRadioButton.getText();
            LocalDate dateBirthLocalDate = birthDateTextField.getValue();

            AlertUTIL alertUTIL = new AlertUTIL();

            membroDTO.setName(nameTextField.getText());
            membroDTO.setEstadoCivil(estadoCivilValue);
            membroDTO.setDataNascimento(dateBirthLocalDate.toString());

            membroDAO.insertMembro(membroDTO);

            nameTextField.setText(null);
            birthDateTextField.setValue(null);

            alertUTIL.showAlert(Alert.AlertType.INFORMATION,"SUCESSO", membroDTO.toString());

        }catch (Exception err){
            AlertUTIL alertUTIL = new AlertUTIL();
            alertUTIL.showAlert(Alert.AlertType.ERROR,"FALHA", err.toString());
        }
    }
}