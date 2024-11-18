package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.VisitorTM;
import edu.ijjse.dehivalazoomanagemetsystem.model.VisitorModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VisitorMngController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<>("visitorId"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("visitorName"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("visitorAddress"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        niccol.setCellValueFactory(new PropertyValueFactory<>("visitorNic"));
        ticketCol.setCellValueFactory(new PropertyValueFactory<>("ticketId"));

        try {
            loadTabel();
            getNextId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
        public void clearForm(){
        idtxt.setText("");
        nametxt.setText("");
        addresstxt.setText("");
        datetxt.setValue(null);
        nictxt.setText("");
        ticketId.setText("");

            try {
                getNextId();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }
        }

    private void getNextId() throws SQLException {
        String id = model.getnextId();
        idtxt.setText(id);
    }

    public void loadTabel() throws SQLException {
        ArrayList<VisitorDto> visitorDtos = model.getAll();
        ObservableList<VisitorTM> visitorTMS = FXCollections.observableArrayList();
        for (VisitorDto visitorDto : visitorDtos) {
            VisitorTM visitorTM = new VisitorTM(
                    visitorDto.getVisitorId(),
                    visitorDto.getVisitorName(),
                    visitorDto.getVisitorAddress(),
                    visitorDto.getVisitDate(),
                    visitorDto.getVisitNic(),
                    visitorDto.getTicketId()
            );
            visitorTMS.add(visitorTM);
        }
        visitortbl.setItems(visitorTMS);
    }

    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<VisitorTM, String> addresscol;

    @FXML
    private JFXTextField addresstxt;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<VisitorTM, String> datecol;

    @FXML
    private DatePicker datetxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<VisitorTM, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<VisitorTM, String> namecol;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private TableColumn<VisitorTM, String> niccol;

    @FXML
    private JFXTextField nictxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableView<VisitorTM> visitortbl;

    @FXML
    private TableColumn<VisitorTM, String> ticketCol;

      @FXML
    private JFXTextField ticketId;


    VisitorModel model = new VisitorModel();

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String address = addresstxt.getText();
        String visitDate = datetxt.getValue().toString();
        String visitNic = nictxt.getText();
        String ticket = ticketId.getText();


        VisitorDto visitorDto = new VisitorDto(id, name, address, visitDate, visitNic, ticket);
        try {
            boolean update = model.update(visitorDto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Visitor Updated").show();
                loadTabel();
                clearForm();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void add(ActionEvent event) throws SQLException {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String address = addresstxt.getText();
        String visitDate = datetxt.getValue().toString();
        String visitNic = nictxt.getText();
        String ticket = ticketId.getText();

        VisitorDto visitorDto = new VisitorDto(id, name, address, visitDate, visitNic,ticket);
        boolean add = model.add(visitorDto);
        if (add) {
            new Alert(Alert.AlertType.INFORMATION, "Visitor Added").show();
            loadTabel();
            clearForm();
        }

    }

    @FXML
    void delete(ActionEvent event) {
    VisitorDto visitorDto = new VisitorDto();
    visitorDto.setVisitorId(idtxt.getText());
        try {
            boolean delete = model.delete(visitorDto);
            if (delete) {
                new Alert(Alert.AlertType.INFORMATION, "Visitor Deleted").show();
                loadTabel();
                clearForm();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
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
    void tabelClicked(MouseEvent event) {
        VisitorTM selectedItem = visitortbl.getSelectionModel().getSelectedItem();
        idtxt.setText(selectedItem.getVisitorId());
        nametxt.setText(selectedItem.getVisitorName());
        addresstxt.setText(selectedItem.getVisitorAddress());
        datetxt.setValue(LocalDate.parse(selectedItem.getVisitDate()));
        nictxt.setText(selectedItem.getVisitorNic());
        ticketId.setText(selectedItem.getTicketId());

    }

}


