package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EncloserDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.EncloserTm;
import edu.ijjse.dehivalazoomanagemetsystem.model.EncloserModel;
import edu.ijjse.dehivalazoomanagemetsystem.utill.RegexUtill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class EncloserController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        locationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        sizecol.setCellValueFactory(new PropertyValueFactory<>("size"));

        loadTbl();
        getnxtId();
    }

    private void loadTbl() {
        try {
            ArrayList<EncloserDto> encloserDtos = model.getAll();
            ObservableList<EncloserTm> encloserTms = FXCollections.observableArrayList();
            for (EncloserDto encloserDto : encloserDtos) {
                EncloserTm encloserTm = new EncloserTm(encloserDto.getId(),encloserDto.getLocation(),encloserDto.getSize());
                encloserTms.add(encloserTm);
            }
            enclosertbl.setItems(encloserTms);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }
    }

    EncloserModel model = new EncloserModel();
    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableView<EncloserTm> enclosertbl;

    @FXML
    private TableColumn<EncloserTm, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<EncloserTm, String> locationcol;

    @FXML
    private JFXTextField locationtxt;

    @FXML
    private TableColumn<EncloserTm, String> sizecol;

    @FXML
    private JFXTextField sizetxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String location = locationtxt.getText();
        String size = sizetxt.getText();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        locationtxt.setStyle(locationtxt.getStyle() + ";-fx-border-color: #7367F0;");
        sizetxt.setStyle(sizetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidSize = RegexUtill.IsValidSize(sizetxt.getText());
        if (!isValidSize) {
            new Alert(Alert.AlertType.ERROR, "Invalid Size").show();
            sizetxt.setStyle(sizetxt.getStyle() + ";-fx-border-color: red;");
        }
        if (isValidSize) {


            EncloserDto encloserDto = new EncloserDto(id, location, size);
            try {
                boolean update = model.update(encloserDto);
                if (update) {
                    new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
                    loadTbl();
                    clearForm();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Update Failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }
        }

    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String location = locationtxt.getText();
        String size = sizetxt.getText();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        locationtxt.setStyle(locationtxt.getStyle() + ";-fx-border-color: #7367F0;");
        sizetxt.setStyle(sizetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidSize = RegexUtill.IsValidSize(sizetxt.getText());
        if (!isValidSize) {
            new Alert(Alert.AlertType.ERROR, "Invalid Size").show();
            sizetxt.setStyle(sizetxt.getStyle() + ";-fx-border-color: red;");
        }
         if (isValidSize){
             EncloserDto encloserDto = new EncloserDto(id,location,size);
             try {
                 boolean add = model.add(encloserDto);
                 if (add) {
                     new Alert(Alert.AlertType.INFORMATION,"Add Successful").show();
                     loadTbl();
                     clearForm();
                 }
                 else {
                     new Alert(Alert.AlertType.ERROR,"Add Failed").show();
                 }
             } catch (SQLException e) {
                 new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
                 e.printStackTrace();
             }
         }

    }
    private void clearForm() {
    idtxt.setText("");
    locationtxt.setText("");
    sizetxt.setText("");
        try {
            getnxtId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    private void getnxtId() throws SQLException {
        String id = model.getnextId();
        idtxt.setText(id);
        System.out.println(id);

    }

    @FXML
    void delete(ActionEvent event) {
        EncloserDto encloserDto = new EncloserDto();
        encloserDto.setId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(encloserDto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Delete Successful").show();
                    loadTbl();
                    clearForm();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Delete Failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage) backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tabelClicked(MouseEvent event) {
        EncloserTm selectedItem = enclosertbl.getSelectionModel().getSelectedItem();
       idtxt.setText(selectedItem.getId());
       locationtxt.setText(selectedItem.getLocation());
       sizetxt.setText(selectedItem.getSize());
    }

}
