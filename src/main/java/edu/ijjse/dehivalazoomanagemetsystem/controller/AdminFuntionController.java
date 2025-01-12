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

    @FXML
    private AnchorPane adminduncpane;

    @FXML
    private ImageView backIcon;

    @FXML
    private Pane dashboard;

    @FXML
    private JFXButton empbtn;

    @FXML
    private JFXButton empfunctionbtn;

    @FXML
    private JFXButton financeBtn;

    @FXML
    private JFXButton taskbtn;

    @FXML
    private JFXButton userbtn;

    @FXML
    private JFXButton vetbtn;

    @FXML
    private AnchorPane innerPane;

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

    public void vetManage(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Vet.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    public void empFunctions(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)financeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }
}
