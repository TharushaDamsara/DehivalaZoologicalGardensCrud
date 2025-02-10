package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.TickDetailsTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.RegexUtill;
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

public class TicketDetails implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        qohcol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadtbl();
        getnextId();
    }

    private void getnextId() {
        try {
            String id = tickDetailsDaoImpl.getNextId();
            idtxt.setText(id);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "ID can not load").show();
            e.printStackTrace();
        }

    }

    private void loadtbl() {
        try {
            ArrayList<TickDetailsDto> tickDetailDtos = tickDetailsDaoImpl.getAll();
            ObservableList<TickDetailsTM> tickDetailsTMS = FXCollections.observableArrayList();
            for (TickDetailsDto tickDetailsdDto : tickDetailDtos) {
                TickDetailsTM tickDetailsTM = new TickDetailsTM(
                        tickDetailsdDto.getId(),
                        tickDetailsdDto.getType(),
                        tickDetailsdDto.getQty(),
                        tickDetailsdDto.getPrice()
                );
                tickDetailsTMS.add(tickDetailsTM);
            }
            ticketDetailstbl.setItems(tickDetailsTMS);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Tabel Con not loaded").show();
            e.printStackTrace();
        }
    }

    TicketDetailsBo tickDetailsDaoImpl = (TicketDetailsBo) BOFactory.getInstance().getBOType(BOFactory.BOType.TicketDetails);

    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<TickDetailsTM, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<TickDetailsTM, Double> pricecol;

    @FXML
    private JFXTextField pricetxt;

    @FXML
    private TableColumn<TickDetailsTM, Integer> qohcol;

    @FXML
    private JFXTextField qohtxt;

    @FXML
    private TableView<TickDetailsTM> ticketDetailstbl;

    @FXML
    private TableColumn<String, TickDetailsTM> typecol;

    @FXML
    private JFXTextField typetxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String type = typetxt.getText();
        int qoh = Integer.parseInt(qohtxt.getText());
        double price = Double.parseDouble(pricetxt.getText());

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        typetxt.setStyle(typetxt.getStyle() + ";-fx-border-color: #7367F0;");
        qohtxt.setStyle(qohtxt.getStyle() + ";-fx-border-color: #7367F0;");
        pricetxt.setStyle(pricetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidAmount = RegexUtill.IsValidAmount(pricetxt.getText());
        boolean isValidQuantity = RegexUtill.IsValidQuantity(qohtxt.getText());
        if (!isValidQuantity ) {
            new Alert(Alert.AlertType.ERROR, "Price is not valid").show();
            qohtxt.setStyle(qohtxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isValidAmount){
            new Alert(Alert.AlertType.ERROR, "Price is not valid").show();
            pricetxt.setStyle(pricetxt.getStyle() + ";-fx-border-color: red;");
        }

        if (isValidAmount && isValidQuantity) {


            TickDetailsDto tickDetailsDto = new TickDetailsDto(id, type, qoh, price);
            try {
                boolean update = tickDetailsDaoImpl.update(tickDetailsDto);
                if (update) {
                    new Alert(Alert.AlertType.INFORMATION, "Ticket updated successfully").show();
                    loadtbl();
                    clearFeilds();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Ticket update failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Update Failed").show();
            }
        }

    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String type = typetxt.getText();
        int qoh = Integer.parseInt(qohtxt.getText());
        double price = Double.parseDouble(pricetxt.getText());

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        typetxt.setStyle(typetxt.getStyle() + ";-fx-border-color: #7367F0;");
        qohtxt.setStyle(qohtxt.getStyle() + ";-fx-border-color: #7367F0;");
        pricetxt.setStyle(pricetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidAmount = RegexUtill.IsValidAmount(pricetxt.getText());
        boolean isValidQuantity = RegexUtill.IsValidQuantity(qohtxt.getText());
        if (!isValidQuantity ) {
            new Alert(Alert.AlertType.ERROR, "Price is not valid").show();
            qohtxt.setStyle(qohtxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isValidAmount){
            new Alert(Alert.AlertType.ERROR, "Price is not valid").show();
            pricetxt.setStyle(pricetxt.getStyle() + ";-fx-border-color: red;");
        }

        if (isValidAmount && isValidQuantity) {
            TickDetailsDto tickDetailsDto = new TickDetailsDto(id, type, qoh, price);
            try {
                boolean add = tickDetailsDaoImpl.add(tickDetailsDto);
                if (add) {
                    new Alert(Alert.AlertType.INFORMATION, "Added Successfully").show();
                    loadtbl();
                    clearFeilds();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Failed to add Details").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,"detail Con not aded").show();
            }
        }
    }

    private void clearFeilds() {
    idtxt.setText("");
    typecol.setText("");
    qohtxt.setText("");
    pricetxt.setText("");
    getnextId();
    }

    @FXML
    void delete(ActionEvent event) {
    TickDetailsDto dto = new TickDetailsDto();
    dto.setId(idtxt.getText());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = tickDetailsDaoImpl.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully").show();
                    loadtbl();
                    clearFeilds();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to delete Details").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Delete Failed").show();
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
        TickDetailsTM selectedItem = ticketDetailstbl.getSelectionModel().getSelectedItem();
        idtxt.setText(selectedItem.getId());
        typetxt.setText(selectedItem.getType());
        qohtxt.setText(String.valueOf(selectedItem.getQty()));
        pricetxt.setText(String.valueOf(selectedItem.getPrice()));

    }

}
