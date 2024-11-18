package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TicketController {

    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private JFXTextField amounttxt;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<?, ?> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<?, ?> paymentTypeClo;

    @FXML
    private JFXTextField paymentTypetxt;

    @FXML
    private TableView<?> ticketTbl;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableColumn<?, ?> visitorIdcol;

    @FXML
    private JFXComboBox<?> visitorIdtxt;

    @FXML
    void Update(ActionEvent event) {

    }

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage)backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tabelClicked(MouseEvent event) {

    }

}
