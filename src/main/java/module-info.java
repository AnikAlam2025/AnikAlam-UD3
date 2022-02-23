module cs112.anikalamud3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cs112.anikalamud3 to javafx.fxml;
    exports cs112.anikalamud3;
}