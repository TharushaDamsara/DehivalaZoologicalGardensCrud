package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.HelthReportBo;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.HelthReportDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.HelthReportTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.HelthReportDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelthReport implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("helthReportId"));
        animalIDcon.setCellValueFactory(new PropertyValueFactory<>("animalId"));
        wetIdCol.setCellValueFactory(new PropertyValueFactory<>("vetId"));
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
            loadtbl();
            loadAnimalId();
            loadVetId();
            getnxtId();
    }

    private void loadVetId() {
        try {
            ArrayList<String> vetId = model.getVetId();
            ObservableList<String> observableList = FXCollections.observableArrayList();
            observableList.addAll(vetId);
            wetIdtxt.setItems(observableList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Can not load Vet Ids").show();
            e.printStackTrace();
        }

    }

    private void loadAnimalId() {
        try {
            ArrayList<String> animalId = model.getAnimalId();
            ObservableList<String> observableList = FXCollections.observableArrayList();
            observableList.addAll(animalId);
            animalIdtxt.setItems(observableList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Can not load Animal Id").show();
            e.printStackTrace();
        }

    }

    private void loadtbl() {
        try {
            ArrayList<HelthReportDto> helthReportDtos = model.getAll();
            ObservableList<HelthReportTM> helthReportTMS = FXCollections.observableArrayList();

            for (HelthReportDto helthReportDto : helthReportDtos) {
                HelthReportTM helthReportTM = new HelthReportTM(
                        helthReportDto.getHelthReportId(),
                        helthReportDto.getAnimalId(),
                        helthReportDto.getVetId(),
                        helthReportDto.getCondition(),
                        helthReportDto.getDate()
                );
                helthReportTMS.add(helthReportTM);
            }
            reporttbl.setItems(helthReportTMS);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }

    }


    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<HelthReportTM, String> animalIDcon;

    @FXML
    private JFXComboBox<String> animalIdtxt;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<HelthReportTM, String> conditionCol;

    @FXML
    private JFXTextField conditionTxt;

    @FXML
    private TableColumn<HelthReportTM, String> dateCol;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<HelthReportTM, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private JFXButton reportbtn;

    @FXML
    private TableView<HelthReportTM> reporttbl;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableColumn<HelthReportTM, String> wetIdCol;

    @FXML
    private JFXComboBox<String> wetIdtxt;

    @FXML
    private TableColumn<HelthReportTM, String> wetNameCol;

    @FXML
    private JFXComboBox<String> wetNametxt;

//    HelthReportDaoImpl model = new HelthReportDaoImpl();
HelthReportBo model = (HelthReportBo) BOFactory.getInstance().getBOType(BOFactory.BOType.HelthReport);

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String animalId = animalIdtxt.getValue();
        String vetId = wetIdtxt.getValue();
        String condition = conditionTxt.getText();
        String date = String.valueOf(dateTxt.getValue());

        HelthReportDto dto = new HelthReportDto(id,animalId,vetId,condition,date);
        try {
            boolean update = model.update(dto);
            System.out.println(update);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION,"Updated Successfully").show();
                loadtbl();
                refreshpage();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Update Failed").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    private void refreshpage() {
    idtxt.setText("");
    animalIdtxt.getSelectionModel().clearSelection();
    wetIdtxt.getSelectionModel().clearSelection();
    conditionTxt.setText("");
    dateTxt.setValue(null);

    getnxtId();
    loadAnimalId();
    loadVetId();
    }

    private void getnxtId() {
        try {
            String nxtId = model.getNextId();
            idtxt.setText(nxtId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }

    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String animalId = animalIdtxt.getValue();
        String vetId = wetIdtxt.getValue();
        String condition = conditionTxt.getText();
        String date = String.valueOf(dateTxt.getValue());

        HelthReportDto dto = new HelthReportDto(id,animalId,vetId,condition,date);
        try {
            boolean add = model.add(dto);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION,"Added Successfully").show();
                loadtbl();
                refreshpage();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Add Failed").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void delete(ActionEvent event) {
    HelthReportDto dto = new HelthReportDto();
    dto.setHelthReportId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully").show();
                    loadtbl();
                    refreshpage();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Delete Failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }
        }

    }

    @FXML
    void genarateReport(ActionEvent event) {

    }



    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage) backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AnimalMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void tabelClicked(MouseEvent event) {
        HelthReportTM selectedItem = reporttbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtxt.setText(selectedItem.getHelthReportId());
            animalIdtxt.setValue(selectedItem.getAnimalId());
            wetIdtxt.setValue(selectedItem.getVetId());
            conditionTxt.setText(selectedItem.getCondition());
            dateTxt.setValue(LocalDate.parse(selectedItem.getDate()));
        }
    }

}
