module com.example.regexpdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regexpdemo to javafx.fxml;
    exports com.example.regexpdemo;
}