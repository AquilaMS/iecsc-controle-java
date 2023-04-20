package com.iecsc.iecsccontrole.Utils;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertUTIL {

    public void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
