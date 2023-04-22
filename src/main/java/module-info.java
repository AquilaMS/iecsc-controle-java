module com.iecsc.iecsccontrole {
    requires javafx.controls;
    requires javafx.fxml;

    requires static lombok;
    requires java.sql;
    requires org.controlsfx.controls;
    requires money.api;
    requires moneta;

    opens com.iecsc.iecsccontrole to javafx.fxml;
    exports com.iecsc.iecsccontrole;
}