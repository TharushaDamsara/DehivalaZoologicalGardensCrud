package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.AnimalExpencessTM;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.AnimalMngTM;
import edu.ijjse.dehivalazoomanagemetsystem.model.AnimalExpencessModel;
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

public class AnimalFinanceController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        expenceidcol.setCellValueFactory(new PropertyValueFactory<>("expenceId"));
        animalidcol.setCellValueFactory(new PropertyValueFactory<>("animalId"));
        amountcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));

        try {
            tabelload();
            getNextid();
            System.out.println("inizial");
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    private void tabelload() throws SQLException {

        ArrayList<AnimalExpencesDto> animalExpencesDtos = model.getAll();
        ObservableList<AnimalExpencessTM>animalExpencessTMS  = FXCollections.observableArrayList();

for (AnimalExpencesDto animalExpencesDto : animalExpencesDtos) {
    AnimalExpencessTM animalExpencessTM = new AnimalExpencessTM(
            animalExpencesDto.getAnimalExpencesId(),
            animalExpencesDto.getAnimalId(),
            animalExpencesDto.getAmount(),
            animalExpencesDto.getDiscription(),
            animalExpencesDto.getDate()
    );
    animalExpencessTMS.add(animalExpencessTM);
}
animalexpencetbl.setItems(animalExpencessTMS);

    }

    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<AnimalExpencessTM, Double> amountcol;

    @FXML
    private JFXTextField amounttxt;

    @FXML
    private TableView<AnimalExpencessTM> animalexpencetbl;

    @FXML
    private TableColumn<AnimalExpencessTM, String> animalidcol;

    @FXML
    private JFXTextField animalidtxt;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<AnimalExpencessTM, String> datecol;

    @FXML
    private DatePicker datetxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<AnimalExpencessTM, String> descCol;

    @FXML
    private JFXTextField desctxt;

    @FXML
    private TableColumn<AnimalExpencessTM, String> expenceidcol;

    @FXML
    private JFXTextField expenceidtxt;

    @FXML
    private JFXButton updatebtn;

    AnimalExpencessModel model = new AnimalExpencessModel();

    @FXML
    void Update(ActionEvent event) throws SQLException {
        String expenceid = expenceidtxt.getText();
        String animalid = animalidtxt.getText();
        double amount = Double.parseDouble(amounttxt.getText()) ;
        String desc = desctxt.getText();
        String expencedate = datetxt.getValue().toString();

        AnimalExpencesDto dto = new AnimalExpencesDto(expenceid,animalid,amount,desc,expencedate);


        try {
            boolean update = model.update(dto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Animal Expences Updated Successfully").show();
                tabelload();
                clearForm();
                getNextid();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR);
        }
    }

    @FXML
    void add(ActionEvent event) {
        String expenceid = expenceidtxt.getText();
        String animalid = animalidtxt.getText();
        double amount = Double.parseDouble(amounttxt.getText()) ;
        String desc = desctxt.getText();
        String expencedate = datetxt.getValue().toString();

        AnimalExpencesDto dto = new AnimalExpencesDto(expenceid,animalid,amount,desc,expencedate);

        try {
            boolean resp = model.add(dto);
            System.out.println(resp);
            if (resp) {
                new Alert(Alert.AlertType.INFORMATION, "Animal Expences Added Successfully").show();
                tabelload();
                clearForm();
                getNextid();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            new Alert(Alert.AlertType.ERROR);
        }
    }

    @FXML
    void delete(ActionEvent event) {
        AnimalExpencesDto dto = new AnimalExpencesDto();
        dto.setAnimalExpencesId(expenceidtxt.getText());

        try {
         //   new Alert(Alert.AlertType.CONFIRMATION, "Are you shuver you want to delete this").show();
            boolean delete = model.delete(dto);
            if (delete) {
                new Alert(Alert.AlertType.INFORMATION, "Animal Expences Deleted").show();
                tabelload();
                clearForm();
                getNextid();
            }
        } catch (SQLException e) {
           new Alert(Alert.AlertType.ERROR);
           e.printStackTrace();
        }
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage)addbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/FinanceMng.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }


    public void tabelClicked(MouseEvent mouseEvent) {

        AnimalExpencessTM expencessTM = animalexpencetbl.getSelectionModel().getSelectedItem();
        if (expencessTM != null) {
            expenceidtxt.setText(expencessTM.getExpenceId());
            animalidtxt.setText(expencessTM.getAnimalId());
            amounttxt.setText(String.valueOf(expencessTM.getAmount()));
            desctxt.setText(expencessTM.getDescription());
            datetxt.setValue(LocalDate.parse(expencessTM.getDate()));

            System.out.println(expencessTM.getAnimalId()+""+expencessTM.getExpenceId()+""+expencessTM.getAmount()+""+expencessTM.getDescription()+""+expencessTM.getDate());

        }
    }
    public void clearForm(){
        animalidtxt.setText("");
        expenceidtxt.setText("");
        amounttxt.setText("");
        desctxt.setText("");
        datetxt.setValue(null);
    }
    public void getNextid() throws SQLException {
        String nextId = model.nextId();
        expenceidtxt.setText(nextId);
    }
}



