package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceMngController {

    @FXML
    private JFXButton aniexpencebtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton empecpnbtn;

    @FXML
    private JFXButton otherexpencebtn;

    @FXML
    void animalexpence(ActionEvent event) throws IOException {
        Stage window = (Stage)aniexpencebtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AnimalFinance.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void employeeexpencess(ActionEvent event) throws IOException {
        Stage window = (Stage)aniexpencebtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/EmpFinance.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage)aniexpencebtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void otherexpences(ActionEvent event) throws IOException {
        Stage window = (Stage)aniexpencebtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/OtherFinance.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

}
