package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.AdminModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class AdminLoginController {

    @FXML
    private AnchorPane adminlogpane;

    @FXML
    private ImageView backbtn;

    @FXML
    private Label dogotpwdlbl;

    @FXML
    private ImageView nexticon;

    @FXML
    private JFXPasswordField pwdtxt;

    @FXML
    private ImageView showpwdIcon;

    @FXML
    private JFXTextField userNametxt;

    AdminModel model = new AdminModel();

    @FXML
    void forgotpwd(MouseEvent event) {

    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        adminlogpane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        adminlogpane.getChildren().add(load);
    }

    @FXML
    void gonextpage(MouseEvent event) throws IOException {

        String userName = userNametxt.getText();
        String pwd = pwdtxt.getText();

        AdminDto dto = new AdminDto(userName, pwd);
        try {
            AdminDto admin = model.getAdmin(dto);
            if (admin.getUsername().equals(userName)||admin.getPassword().equals(pwd)) {
                adminlogpane.getChildren().clear();
                AnchorPane load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
                adminlogpane.getChildren().add(load);
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

            e.printStackTrace();
        }

    }

    @FXML
    void nextpage(ActionEvent event) throws IOException {

        String userName = userNametxt.getText();
        String pwd = pwdtxt.getText();

        AdminDto dto = new AdminDto(userName, pwd);
        try {
            AdminDto admin = model.getAdmin(dto);
            if (admin.getUsername().equals(dto.getUsername())||admin.getPassword().equals(dto.getPassword())) {
                adminlogpane.getChildren().clear();
                AnchorPane load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
                adminlogpane.getChildren().add(load);
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
    @FXML
    void showpwd(MouseEvent event) {

    }
}
