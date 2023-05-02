package com.iecsc.iecsccontrole;

import com.iecsc.iecsccontrole.DAO.MembroDAO;
import com.iecsc.iecsccontrole.DAO.Teste;
import com.iecsc.iecsccontrole.DTO.MembroDTO;
import com.iecsc.iecsccontrole.Services.MembroService;
import com.iecsc.iecsccontrole.Services.RegisterService;
import com.iecsc.iecsccontrole.Utils.AlertUTIL;
import com.iecsc.iecsccontrole.Utils.CurrencyConverter;
import com.iecsc.iecsccontrole.Utils.RegisterType;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.textfield.TextFields;

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
    private TextField insertValueTextField;

    @FXML
    private TextField insertRegisterTypeTextField;

    @FXML
    protected void  onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Teste teste = new Teste();
        teste.testarConnection();
    }

    @FXML
    public void initialize() {
        ObservableList<String> registerTypesOptions = FXCollections.observableArrayList();
        for(RegisterType registerType : RegisterType.values()){
            registerTypesOptions.add(registerType.name());
        }
        TextFields.bindAutoCompletion(insertRegisterTypeTextField, registerTypesOptions);
        insertValueTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                CurrencyConverter converter = new CurrencyConverter();
                insertValueTextField.setText(converter.convertStringToCurrency(newValue));
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

    @FXML
    protected void onInsertRegister(){
        RegisterService registerService = new RegisterService();
        registerService.insertRegister(insertValueTextField, insertRegisterTypeTextField);
    }
}