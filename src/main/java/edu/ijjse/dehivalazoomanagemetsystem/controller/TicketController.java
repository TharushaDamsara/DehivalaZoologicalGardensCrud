package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TicketDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.tm.TicketTm;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.TicketDaoImpl;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.RegexUtill;
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

public class TicketController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("ticketCode"));
        visitorIdcol.setCellValueFactory(new PropertyValueFactory<>("visitorId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentTypeCol.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        qtycol.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadTbl();
        getVisitorIds();
        getTypeids();
        getnextId();
      //  datelbl.setText(LocalDate.now().toString());
    }

    private void getTypeids() {
        try {
            ArrayList<String> typeIds = model.getTypeIds();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(typeIds);
            typetxt.setItems(objects);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }


    }

    private void getnextId() {
        try {
            String id = model.getNextId();
            idtxt.setText(id);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    private void getVisitorIds() {
        try {
            ArrayList<String> visitorId = model.getVisitorId();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(visitorId);
            visitorIdtxt.setItems(objects);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }

    }

    private void loadTbl() {
        try {
            ArrayList<TicketDto> ticketDtos = model.getAll();
            ObservableList<TicketTm> ticketTms = FXCollections.observableArrayList();
            for (TicketDto ticketDto : ticketDtos) {
                TicketTm ticketTm = new TicketTm(
                        ticketDto.getTicketCode(),
                        ticketDto.getVisitorId(),
                        ticketDto.getType(),
                        ticketDto.getDate(),
                        ticketDto.getQty(),
                        ticketDto.getAmount(),
                        ticketDto.getPaymentType()
                );
                ticketTms.add(ticketTm);
            }
            ticketTbl.setItems(ticketTms);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }
    }
TicketDaoImpl model = new TicketDaoImpl();
    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<TicketTm, Double> amountCol;

    @FXML
    private JFXTextField amounttxt;

    @FXML
    private Label datelbl;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<TicketTm, String> dateCol;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<TicketTm, String> idcol;

    @FXML
    private TableColumn<TicketTm, String> typeCol;

    @FXML
    private JFXComboBox<String> typetxt;

    @FXML
    private JFXTextField qtytxt;

    @FXML
    private TableColumn<TicketTm, String> qtycol;

    @FXML
    private JFXTextField idtxt;
    @FXML
    private Label typelbl;
    @FXML
    private TableColumn<TicketTm, String> paymentTypeCol;

    @FXML
    private JFXTextField paymentTypetxt;

    @FXML
    private TableView<TicketTm> ticketTbl;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private Label priceLbl;

    @FXML
    private Label qohlbl;

    @FXML
    private TableColumn<TicketTm, String> visitorIdcol;

    @FXML
    private JFXComboBox<String> visitorIdtxt;

    @FXML
    void Update(ActionEvent event) {
        if (visitorIdtxt.getValue().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select visitor id", ButtonType.OK).show();
           return;
        }
       if (typetxt.getValue().isEmpty()) {
           new Alert(Alert.AlertType.ERROR, "Please select type", ButtonType.OK).show();
            return;
       }

         String id = idtxt.getText();
        String visitorId = visitorIdtxt.getValue();
        String type = typetxt.getValue();
        String date = String.valueOf(dateTxt.getValue());
        int qty = Integer.parseInt(qtytxt.getText());
        double amount = Double.parseDouble(amounttxt.getText());
        String paymentType = paymentTypetxt.getText();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        typetxt.setStyle(typetxt.getStyle() + ";-fx-border-color: #7367F0;");
        dateTxt.setStyle(dateTxt.getStyle() + ";-fx-border-color: #7367F0;");
        qtytxt.setStyle(qtytxt.getStyle() + ";-fx-border-color: #7367F0;");
        amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: #7367F0;");
        paymentTypetxt.setStyle(paymentTypetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidQuantity = RegexUtill.IsValidQuantity(qtytxt.getText());
        boolean isValidAmount = RegexUtill.IsValidAmount(amounttxt.getText());
        if (!isValidQuantity){
            new Alert(Alert.AlertType.ERROR, "Invalid Quantity", ButtonType.OK).show();
            qtytxt.setStyle(qtytxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isValidAmount){
            new Alert(Alert.AlertType.ERROR, "Invalid Amount", ButtonType.OK).show();
            amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: red;");
        }
        if (isValidQuantity && isValidAmount) {
            TicketDto dto = new TicketDto(id,visitorId,type,date,qty,amount,paymentType);
            try {
                boolean update = model.update(dto);
                if (update) {
                    new Alert(Alert.AlertType.INFORMATION, "Ticket updated successfully").show();
                    loadTbl();
                    refreshPage();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Ticket update failed").show();
                }

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
                e.printStackTrace();
            }
        }

    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String visitorId = visitorIdtxt.getValue();
        String type = typetxt.getValue();
        String date = String.valueOf(dateTxt.getValue());
        int qty = Integer.parseInt(qtytxt.getText());
        double amount = Double.parseDouble(amounttxt.getText());
        String paymentType = paymentTypetxt.getText();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        typetxt.setStyle(typetxt.getStyle() + ";-fx-border-color: #7367F0;");
        dateTxt.setStyle(dateTxt.getStyle() + ";-fx-border-color: #7367F0;");
        qtytxt.setStyle(qtytxt.getStyle() + ";-fx-border-color: #7367F0;");
        amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: #7367F0;");
        paymentTypetxt.setStyle(paymentTypetxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isValidQuantity = RegexUtill.IsValidQuantity(qtytxt.getText());
        boolean isValidAmount = RegexUtill.IsValidAmount(amounttxt.getText());
        if (!isValidQuantity){
            new Alert(Alert.AlertType.ERROR, "Invalid Quantity", ButtonType.OK).show();
            qtytxt.setStyle(qtytxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isValidAmount){
            new Alert(Alert.AlertType.ERROR, "Invalid Amount", ButtonType.OK).show();
            amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: red;");
        }
        if (isValidQuantity && isValidAmount) {


            TicketDto dto = new TicketDto(id, visitorId, type, date, qty, amount, paymentType);

            int qoh = Integer.parseInt(qohlbl.getText());
            double price = Double.parseDouble(priceLbl.getText());


            if (qoh < qty) {
                new Alert(Alert.AlertType.ERROR, "Qohl limit reached").show();
                return;
            }


            try {
                boolean add = model.add(dto);
                if (add) {
                    new Alert(Alert.AlertType.INFORMATION, "Ticket added successfully").show();
                    loadTbl();
                    refreshPage();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Ticket added failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }

        }
    }

    private void refreshPage() {
    idtxt.setText("");
    visitorIdtxt.getSelectionModel().clearSelection();
    dateTxt.setValue(null);
    amounttxt.setText("");
    paymentTypetxt.setText("");
    typetxt.getSelectionModel().clearSelection();
    qtytxt.setText("");

    getnextId();

    }

    @FXML
    void delete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            TicketDto dto = new TicketDto();
            dto.setTicketCode(idtxt.getText());
            dto.setType(typetxt.getValue());
            dto.setQty(Integer.parseInt(qtytxt.getText()));
            try {
                boolean delete = model.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Ticket deleted successfully").show();
                    loadTbl();
                    refreshPage();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Ticket deletion failed").show();
                }

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }
        }

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
        TicketTm selectedItem = ticketTbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtxt.setText(selectedItem.getTicketCode());
            visitorIdtxt.setValue(selectedItem.getVisitorId());
            dateTxt.setValue(LocalDate.parse(selectedItem.getDate()));
            amounttxt.setText(String.valueOf(selectedItem.getAmount()));
            paymentTypetxt.setText(selectedItem.getPaymentType());
            typetxt.setValue(selectedItem.getType());
            qtytxt.setText(String.valueOf(selectedItem.getQty()));
        }
        else {
            new Alert(Alert.AlertType.ERROR, "No ticket selected").show();
        }


    }

    public void typecmbOnaction(ActionEvent actionEvent) {
        String selectedItem = typetxt.getSelectionModel().getSelectedItem();
        try {
            TickDetailsDto byId = model.findById(selectedItem);
            priceLbl.setText(String.valueOf(byId.getPrice()));
            qohlbl.setText(String.valueOf(byId.getQty()));
            typelbl.setText(byId.getType());

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    public void amountenterd(ActionEvent actionEvent) {

        int qty = Integer.parseInt(qtytxt.getText());
        double price = Double.parseDouble(priceLbl.getText());
        double total = qty * price;
        amounttxt.setText(String.valueOf(total));
    }
}
