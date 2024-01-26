module com.example.onlineshopingmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.onlineshopingmanagementsystem.project.clientside to javafx.fxml,javafx.graphics, javafx.base;
    exports com.example.onlineshopingmanagementsystem;
    opens com.example.onlineshopingmanagementsystem.project.serverside to javafx.graphics;

}
