module org.example.lab01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab01 to javafx.fxml;
    exports org.example.lab01;
}