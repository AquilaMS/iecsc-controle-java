package com.iecsc.iecsccontrole;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DAO.Teste;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.Services.MembroService;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import com.iecsc.iecsccontrole.Utils.CurrencyConverter;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    //
    //
    @FXML
    private TextField insertPutTextField;

    @FXML
    protected void  onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Teste teste = new Teste();
        teste.testarConnection();
    }

    @FXML
    public void initialize() {
        insertPutTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                CurrencyConverter converter = new CurrencyConverter();
                insertPutTextField.setText(converter.convertStringToCurrency(newValue));
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        });
    }

    @FXML
    protected void onInsertMembro(){
        MembroService membroService = new MembroService();
        membroService.insertMembro(birthDateTextField, nameTextField, estadoCivil);
    }

}