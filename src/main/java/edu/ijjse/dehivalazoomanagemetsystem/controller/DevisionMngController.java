package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.DevisionBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.DevisionDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.DevisionTM;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class DevisionMngController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idclm.setCellValueFactory(new PropertyValueFactory<>("devisionId"));
        nameclm.setCellValueFactory(new PropertyValueFactory<>("devisionName"));
        descclm.setCellValueFactory(new PropertyValueFactory<>("devisionDescription"));
        try {
            loadTabel();
            getnxtId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void loadTabel() throws SQLException {
        ArrayList<DevisionDto> devisionDtos = devisionBo.getAll();
        ObservableList<DevisionTM> devisionTMS= FXCollections.observableArrayList();
        for (DevisionDto devisionDto : devisionDtos) {
            DevisionTM devisionTM = new DevisionTM(
                    devisionDto.getDevisionId(),
                    devisionDto.getDevisionName(),
                    devisionDto.getDevisionDescription()
            );
            devisionTMS.add(devisionTM);
        }
        devisiontbl.setItems(devisionTMS);
    }

    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<DevisionTM, String> descclm;

    @FXML
    private JFXTextField desctxt;

    @FXML
    private TableView<DevisionTM> devisiontbl;

    @FXML
    private TableColumn<DevisionTM, String> idclm;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<DevisionTM, String> nameclm;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private JFXButton updatebtn;

   DevisionBo devisionBo = (DevisionBo) BOFactory.getInstance().getBOType(BOFactory.BOType.Devision);


    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String desc = desctxt.getText();
        DevisionDto dto = new DevisionDto(id, name, desc);
        try {
            boolean update = devisionBo.update(dto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Devision updated successfully").show();
                loadTabel();
                clearForm();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void clearForm() {
        idtxt.setText("");
        nametxt.setText("");
        desctxt.setText("");

        try {
            getnxtId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void getnxtId() throws SQLException {
        String nextDevisionId = devisionBo.getNextId();
        idtxt.setText(nextDevisionId);


    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String desc = desctxt.getText();
        DevisionDto dto = new DevisionDto(id, name, desc);
        try {
            boolean add = devisionBo.add(dto);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Devision added successfully").show();
                loadTabel();
                clearForm();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void delete(ActionEvent event) {
    DevisionDto dto = new DevisionDto();
    dto.setDevisionId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete =devisionBo.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Devision deleted successfully").show();
                    loadTabel();
                    clearForm();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Devision not deleted").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void goback(MouseEvent event) throws IOException {

        Stage window = (Stage)addbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void tableClicked(MouseEvent event) {
        DevisionTM selectedItem = devisiontbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtxt.setText(selectedItem.getDevisionId());
            nametxt.setText(selectedItem.getDevisionName());
            desctxt.setText(selectedItem.getDevisionDescription());
        }
    }

}

