package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminPageController {

    @FXML
    private AnchorPane adminpagePane;

    @FXML
    private ImageView backicon;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private JFXButton nxtbtn;

    @FXML
    private JFXPasswordField pwdtxt;

    @FXML
    void goback(MouseEvent event) throws IOException {
        adminpagePane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        adminpagePane.getChildren().add(load);
    }

    @FXML
    void nextpage(ActionEvent event) throws IOException {
    adminpagePane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        adminpagePane.getChildren().add(load);
    }

}
