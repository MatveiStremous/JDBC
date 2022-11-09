module com.example.jdbc {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens com.example.jdbc to javafx.fxml;
    exports com.example.jdbc;
    exports com.example.jdbc.Server.entity;
    opens com.example.jdbc.Server.entity to javafx.fxml;
}