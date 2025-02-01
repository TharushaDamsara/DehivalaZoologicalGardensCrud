package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.AnimalExpences;
import edu.ijjse.dehivalazoomanagemetsystem.entity.tm.AnimalExpencessTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.AnimalExpencessDaoImpl;
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
            getAnimalIds();
            System.out.println("inizial");
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    private void getAnimalIds() {
        try {
            ArrayList<String> animalIds = animalExpencessDao.getAnimalIds();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(animalIds);
            animalidtxt.setItems(objects);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void tabelload() throws SQLException {

        ArrayList<AnimalExpences> animalExpences = animalExpencessDao.getAll();
        ObservableList<AnimalExpencessTM>animalExpencessTMS  = FXCollections.observableArrayList();

for (AnimalExpences animalExpencesd : animalExpences) {
    AnimalExpencessTM animalExpencessTM = new AnimalExpencessTM(
            animalExpencesd.getAnimalExpencesId(),
            animalExpencesd.getAnimalId(),
            animalExpencesd.getAmount(),
            animalExpencesd.getDiscription(),
            animalExpencesd.getDate()
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
    private JFXComboBox<String> animalidtxt;

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

    AnimalExpencessDao animalExpencessDao = new AnimalExpencessDaoImpl();


    @FXML
    void Update(ActionEvent event) throws SQLException {
        String expenceid = expenceidtxt.getText();
        String animalid = animalidtxt.getValue();
        double amount = Double.parseDouble(amounttxt.getText());
        String desc = desctxt.getText();
        String expencedate = datetxt.getValue().toString();

        expenceidtxt.setStyle(expenceidtxt.getStyle()+"-fx-border-color: #7367F0;");
        animalidtxt.setStyle(animalidtxt.getStyle()+"-fx-border-color: #7367F0;");
        amounttxt.setStyle(amounttxt.getStyle() + "-fx-border-color: #7367F0;");
        desctxt.setStyle(desctxt.getStyle()+"-fx-border-color: #7367F0;");
        datetxt.setStyle(datetxt.getStyle()+"-fx-border-color: #7367F0;");


        boolean isValidAmount = RegexUtill.IsValidAmount(String.valueOf(amounttxt));
        boolean isValidDate = RegexUtill.IsValidDate(String.valueOf(datetxt));

        if (!isValidAmount) {
            amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: red;");
            System.out.println(amounttxt.getStyle());
           // new Alert(Alert.AlertType.ERROR, "Amount is not valid", ButtonType.OK).show();
        }
        if (!isValidDate) {
            datetxt.setStyle(datetxt.getStyle() + ";-fx-border-color: red;");
        }
        if (isValidAmount&isValidDate) {
            AnimalExpences dto = new AnimalExpences(expenceid,animalid,amount,desc,expencedate);
            try {
                boolean update = animalExpencessDao.update(dto);
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

    }

    @FXML
    void add(ActionEvent event) {

        String expenceid = expenceidtxt.getText();
        String animalid = animalidtxt.getValue();
        double amount = Double.parseDouble(amounttxt.getText()) ;
        String desc = desctxt.getText();
        String expencedate = datetxt.getValue().toString();

        expenceidtxt.setStyle(expenceidtxt.getStyle()+"-fx-border-color: #7367F0;");
        animalidtxt.setStyle(animalidtxt.getStyle()+"-fx-border-color: #7367F0;");
        amounttxt.setStyle(amounttxt.getStyle() + "-fx-border-color: #7367F0;");
        desctxt.setStyle(desctxt.getStyle()+"-fx-border-color: #7367F0;");
        datetxt.setStyle(datetxt.getStyle()+"-fx-border-color: #7367F0;");


        boolean isValidAmount = RegexUtill.IsValidAmount(String.valueOf(amounttxt));
        boolean isValidDate = RegexUtill.IsValidDate(String.valueOf(datetxt));

        if (!isValidAmount) {
            amounttxt.setStyle(amounttxt.getStyle() + ";-fx-border-color: red;");
            System.out.println(amounttxt.getStyle());
             new Alert(Alert.AlertType.ERROR, "Amount is not valid", ButtonType.OK).show();
        }
        if (!isValidDate) {
            datetxt.setStyle(datetxt.getStyle() + ";-fx-border-color: red;");
        }
        if (isValidAmount&isValidDate) {


            AnimalExpences dto = new AnimalExpences(expenceid, animalid, amount, desc, expencedate);

            try {
                boolean resp = animalExpencessDao.add(dto);
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
    }

    @FXML
    void delete(ActionEvent event) {

        AnimalExpences dto = new AnimalExpences();
        dto.setAnimalExpencesId(expenceidtxt.getText());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {

                boolean delete = animalExpencessDao.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Animal Expences Deleted").show();
                    tabelload();
                    clearForm();
                    getNextid();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Animal Expences Not Deleted").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR);
                e.printStackTrace();
            }
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
            animalidtxt.setValue(expencessTM.getAnimalId());
            amounttxt.setText(String.valueOf(expencessTM.getAmount()));
            desctxt.setText(expencessTM.getDescription());
            datetxt.setValue(LocalDate.parse(expencessTM.getDate()));

            System.out.println(expencessTM.getAnimalId()+""+expencessTM.getExpenceId()+""+expencessTM.getAmount()+""+expencessTM.getDescription()+""+expencessTM.getDate());

        }
    }
    public void clearForm(){
        animalidtxt.getSelectionModel().clearSelection();
        expenceidtxt.setText("");
        amounttxt.setText("");
        desctxt.setText("");
        datetxt.setValue(null);
    }
    public void getNextid() throws SQLException {
        String nextId = animalExpencessDao.getNextId();
        expenceidtxt.setText(nextId);
    }
}



