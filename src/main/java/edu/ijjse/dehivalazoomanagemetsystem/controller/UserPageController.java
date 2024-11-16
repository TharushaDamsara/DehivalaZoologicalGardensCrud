package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class UserPageController {

    @FXML
    private JFXButton Adminbtn;

    @FXML
    private AnchorPane firstpagepane;

    @FXML
    private ImageView logOuticon;

    @FXML
    void adminLogin(ActionEvent event) throws IOException {
        Stage window = (Stage) Adminbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminLogin.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();



    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void userLogin(ActionEvent event) throws IOException {
        Stage window = (Stage) Adminbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/EmpLogin.fxml."));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

}
