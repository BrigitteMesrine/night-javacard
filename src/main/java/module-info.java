module fr.afpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens fr.afpa to javafx.fxml;
    exports fr.afpa;
    exports fr.afpa.models;
}
