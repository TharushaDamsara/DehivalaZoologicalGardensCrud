package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VetDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.VetTM;
import edu.ijjse.dehivalazoomanagemetsystem.model.VetModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VetController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("vetId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("vetName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("vetAddress"));
        tpCol.setCellValueFactory(new PropertyValueFactory<>("vetPhone"));

        loadTbl();
        getnxtId();
    }

    private void getnxtId() {
        try {
            String id = model.getnxtId();
            idtxt.setText(id);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    private void loadTbl() {
        try {
            ArrayList<VetDto> dtos = model.getAll();
            ObservableList<VetTM> objects = FXCollections.observableArrayList();
            for (VetDto dto : dtos) {
                VetTM vetTM = new VetTM(
                  dto.getVetId(),
                  dto.getVetName(),
                  dto.getVetAddress(),
                  dto.getVetPhone()
                );
                objects.add(vetTM);
            }
            enclosertbl.setItems(objects);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
  VetModel model = new VetModel();
    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<VetTM, String> addressCol;

    @FXML
    private JFXTextField adresstxt;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableView<VetTM> enclosertbl;

    @FXML
    private TableColumn<VetTM, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<VetTM, String> nameCol;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private TableColumn<VetTM, String> tpCol;

    @FXML
    private JFXTextField tptxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String address = adresstxt.getText();
        String phone = tptxt.getText();
        VetDto dto = new VetDto(id, name, address, phone);
        try {
            boolean update = model.update(dto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION,"Vet Updated").show();
                loadTbl();
                refeshPage();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Vet Not Updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }


    }

    private void refeshPage() {
    idtxt.setText("");
    nametxt.setText("");
    adresstxt.setText("");
    tptxt.setText("");
     getnxtId();
    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String address = adresstxt.getText();
        String phone = tptxt.getText();
        VetDto dto = new VetDto(id, name, address, phone);
        try {
            boolean add = model.add(dto);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION,"Vet Added").show();
                loadTbl();
                refeshPage();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Vet Not Added").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }


    }

    @FXML
    void delete(ActionEvent event) {
    VetDto dto = new VetDto();
    dto.setVetId(idtxt.getText());
        try {
            boolean delete = model.delete(dto);
            if (delete) {
                new Alert(Alert.AlertType.INFORMATION,"Vet Deleted").show();
                loadTbl();
                refeshPage();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Vet Not Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage)backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tabelClicked(MouseEvent event) {
        VetTM selectedItem = enclosertbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtxt.setText(selectedItem.getVetId());
            nametxt.setText(selectedItem.getVetName());
            adresstxt.setText(selectedItem.getVetAddress());
            tptxt.setText(selectedItem.getVetPhone());
        }

    }

}
