package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EventDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.tm.EventTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.EventDaoImpl;
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

public class EventMngController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idclm.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        nameclm.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        locationclm.setCellValueFactory(new PropertyValueFactory<>("eventLocation"));
        dateclm.setCellValueFactory(new PropertyValueFactory<>("eventDate"));

        try {
            loadtabel();
            loadnextId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void loadtabel() throws SQLException {
        ArrayList<EventDto> eventDtos = model.getAll();
        ObservableList<EventTM> eventTMS = FXCollections.observableArrayList();

        for (EventDto eventDto : eventDtos) {
            EventTM eventTM = new EventTM(
              eventDto.getEventId(),
              eventDto.getEventName(),
              eventDto.getEventLocation(),
              eventDto.getEventDate()
            );
            eventTMS.add(eventTM);
        }
        eventtbl.setItems(eventTMS);
    }

    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<EventTM, String> dateclm;

    @FXML
    private DatePicker datetxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<EventTM, String> idclm;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<EventTM, String> locationclm;

    @FXML
    private JFXTextField locationtxt;

    @FXML
    private TableColumn<EventTM, String> nameclm;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableView<EventTM> eventtbl;


    EventDaoImpl model = new EventDaoImpl();

    @FXML
    void Update(ActionEvent event) {

        String id = idtxt.getText();
        String name = nametxt.getText();
        String location = locationtxt.getText();
        String date = datetxt.getValue().toString();
        EventDto eventDto = new EventDto(id,name,location,date);

        try {
            boolean update = model.update(eventDto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Event updated successfully").show();
                loadtabel();
                clearForm();

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String name = nametxt.getText();
        String location = locationtxt.getText();
        String date = datetxt.getValue().toString();
        EventDto eventDto = new EventDto(id,name,location,date);
        try {
            boolean save = model.add(eventDto);
            if (save){
                new Alert(Alert.AlertType.INFORMATION, "Event added successfully").show();
                loadtabel();
                clearForm();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearForm() {
    idtxt.setText("");
    nametxt.setText("");
    locationtxt.setText("");
    datetxt.setValue(null);

        try {
            loadnextId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void delete(ActionEvent event) {
    EventDto eventDto = new EventDto();
    eventDto.setEventId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(eventDto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Event deleted successfully").show();
                    clearForm();
                    loadtabel();
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

    public void tblclicked(MouseEvent mouseEvent) {
        EventTM selectedItem = eventtbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtxt.setText(selectedItem.getEventId());
            nametxt.setText(selectedItem.getEventName());
            locationtxt.setText(selectedItem.getEventLocation());
            datetxt.setValue(LocalDate.parse(selectedItem.getEventDate()));
        }
    }
    public void loadnextId() throws SQLException {
        String id = model.getNextId();
        idtxt.setText(id);

    }
}
