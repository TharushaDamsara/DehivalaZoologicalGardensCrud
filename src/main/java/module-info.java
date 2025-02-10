module edu.ijjse.dehivalazoomanagemetsystem {
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.controls;
    requires java.sql;
    requires static lombok;


   // opens edu.ijjse.dehivalazoomanagemetsystem.entity.tm to javafx.fxml;
    opens edu.ijjse.dehivalazoomanagemetsystem.controller to javafx.fxml;
    exports edu.ijjse.dehivalazoomanagemetsystem;
    exports edu.ijjse.dehivalazoomanagemetsystem.tm;
    opens view to javafx.fxml;
    opens edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl to javafx.fxml;
    opens edu.ijjse.dehivalazoomanagemetsystem.dao.custom to javafx.fxml;
}