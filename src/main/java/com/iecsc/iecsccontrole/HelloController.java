package com.iecsc.iecsccontrole;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DAO.Teste;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameTextField;

    @FXML
    protected void  onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Teste teste = new Teste();
        teste.testarConnection();
    }

    @FXML
    protected void onInsertMembro(){
        MembroDTO membroDTO = new MembroDTO();
        MembroDAO membroDAO = new MembroDAO();

        membroDTO.setName(nameTextField.getText());
        membroDTO.setEstado_civil("solteiro");
        membroDTO.setData_nascimento("01/01/1991");
        
        membroDAO.insertMembro(membroDTO);

        System.out.println(membroDAO.toString());
    }
}