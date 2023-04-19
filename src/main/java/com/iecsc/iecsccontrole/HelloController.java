package com.iecsc.iecsccontrole;

import com.iecsc.iecsccontrole.DAO.Teste;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void  onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Teste teste = new Teste();
        teste.testarConnection();
    }
}