package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EmpLoginController {

    @FXML
    private ImageView backIcon;

    @FXML
    private Label dogotpwdlbl;

    @FXML
    private AnchorPane emploginpane;

    @FXML
    private ImageView nexticon;

    @FXML
    private ImageView pwdicon;

    @FXML
    private JFXPasswordField pwdtxt;

    @FXML
    private JFXTextField usertxt;
        UserModel model = new UserModel();
    @FXML
    void forgotpwd(MouseEvent event) {

    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage window = (Stage) backIcon.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void gonextpage(MouseEvent event) throws IOException, SQLException {

try {
    String userName = usertxt.getText();
    String pwd = pwdtxt.getText();
    boolean b = model.getUserCredential(userName, pwd);
    System.out.println(userName + pwd);
    if (b) {
        System.out.println(b);
        Stage window = (Stage) backIcon.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    } else {
        new Alert(Alert.AlertType.ERROR, "Wrong Password").show();
    }
}catch (Exception e) {

    e.printStackTrace();
}

   }

    @FXML
    void seepwd(MouseEvent event) {

    }

    public void pwdenterd(ActionEvent actionEvent) {

        try {
            String userName = usertxt.getText();
            String pwd = pwdtxt.getText();
            boolean b = model.getUserCredential(userName, pwd);
            System.out.println(userName + pwd);
            if (b) {
                System.out.println(b);
                Stage window = (Stage) backIcon.getScene().getWindow();
                window.close();
                Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
                Scene scene = new Scene(load);
                window.setScene(scene);
                window.show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Wrong Password").show();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    }
