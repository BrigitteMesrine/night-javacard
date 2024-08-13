module fr.afpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires transitive javafx.base;
    requires transitive javafx.graphics;

    opens fr.afpa to javafx.fxml;
    exports fr.afpa;
    exports fr.afpa.models;
}
