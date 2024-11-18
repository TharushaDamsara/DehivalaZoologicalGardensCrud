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

import java.io.IOException;

public class UserFuntionController {

    @FXML
    private JFXButton animalmngBtn;

    @FXML
    private ImageView backIcon;

    @FXML
    private JFXButton devisionmngbtn;

    @FXML
    private AnchorPane empmngpane;

    @FXML
    private JFXButton eventmngbtn;

    @FXML
    private JFXButton visitormngbtn;
    @FXML
    private JFXButton userbtn;

    @FXML
    private JFXButton encloserBtn;

    @FXML
    private JFXButton ticketBtn;


    @FXML
    void animalmng(ActionEvent event) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AnimalMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void devisionmng(ActionEvent event) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Devisionmng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void eventmng(ActionEvent event) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/EventMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void visitormng(ActionEvent event) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Visitormng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    public void encloserMng(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Encloser.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    public void ticketMng(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) animalmngBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Ticket.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }
}
