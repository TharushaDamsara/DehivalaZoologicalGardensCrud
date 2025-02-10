package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AdminBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AdminDao;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.AdminDaoImpl;
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
    AdminBo adminBo = (AdminBo) BOFactory.getInstance().getBOType(BOFactory.BOType.Admin);
//    AdminDao adminBo = new AdminDaoImpl();
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

        try {
            boolean resp = adminBo.getAdmin(userName,pwd);
            if (resp) {
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

        try {
            boolean resp = adminBo.getAdmin(userName, pwd);
            if (resp) {
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
