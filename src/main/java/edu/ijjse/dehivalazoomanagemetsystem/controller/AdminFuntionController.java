package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminFuntionController {

    public JFXButton userbtn;
    @FXML
    private AnchorPane adminduncpane;

    @FXML
    private ImageView backIcon;

    @FXML
    private JFXButton empbtn;

    @FXML
    private JFXButton financeBtn;

    @FXML
    private AnchorPane secpane;

    @FXML
    private Pane funcsubpane;


    @FXML
    private JFXButton taskbtn;


    @FXML
    void empmngment(ActionEvent event) throws IOException {


        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/EmployeeManage.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void financemngmnt(ActionEvent event) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/FinanceMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    public void userMng(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UseDetailMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    public void taskManage(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/TaskManage.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }
}
