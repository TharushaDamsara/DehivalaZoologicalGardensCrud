package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.EmployeeExpencessTM;
import edu.ijjse.dehivalazoomanagemetsystem.model.EmpExpencessModel;
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
import java.util.ResourceBundle;

public class EmployeeFinanceController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            ipaydcol.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
            empidcol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
            basicsalcol.setCellValueFactory(new PropertyValueFactory<>("basic"));
            addonscol.setCellValueFactory(new PropertyValueFactory<>("addons"));
            cutoffcol.setCellValueFactory(new PropertyValueFactory<>("cutOffs"));
            totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));
            try {
                loadTbl();
                getnxtId();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK).show();
            }
        }
    private void loadTbl() throws SQLException {
        ArrayList<EmployeeExpencesDto> employeeExpencesDtos = model.viewAll();
        ObservableList<EmployeeExpencessTM> employeeExpencessTMS = FXCollections.observableArrayList();

        for (EmployeeExpencesDto employeeExpencesDto : employeeExpencesDtos) {
            EmployeeExpencessTM employeeExpencessTM = new EmployeeExpencessTM(
                    employeeExpencesDto.getPaymentId(),
                    employeeExpencesDto.getEmployeeId(),
                    employeeExpencesDto.getDate(),
                    employeeExpencesDto.getBasicSalary(),
                    employeeExpencesDto.getAddonSalary(),
                    employeeExpencesDto.getCutOffSalary(),
                    employeeExpencesDto.getTotalSalary()
            );
           employeeExpencessTMS.add(employeeExpencessTM);
        }
        salarytbl.setItems(employeeExpencessTMS);
    }


    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<EmployeeExpencessTM, Double> addonscol;

    @FXML
    private JFXTextField addontxt;

    @FXML
    private ImageView backIcon;

    @FXML
    private TableColumn<EmployeeExpencessTM, Double> basicsalcol;

    @FXML
    private JFXTextField basicsaltxt;

    @FXML
    private TableColumn<EmployeeExpencessTM, Double> cutoffcol;

    @FXML
    private JFXTextField cutoffstxt;

    @FXML
    private TableColumn<EmployeeExpencessTM, String> datecol;

    @FXML
    private DatePicker datetxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private TableColumn<EmployeeExpencessTM, String> empidcol;

    @FXML
    private JFXTextField empidtxt;

    @FXML
    private JFXTextField idtext;

    @FXML
    private TableColumn<EmployeeExpencessTM, String> ipaydcol;

    @FXML
    private TableView<EmployeeExpencessTM> salarytbl;

    @FXML
    private TableColumn<EmployeeExpencessTM, Double> totalcol;

    @FXML
    private JFXTextField totsaltxt;

    @FXML
    private JFXButton updatebtn;

    EmpExpencessModel model = new EmpExpencessModel();

    @FXML
    void UpdateEmp(ActionEvent event) {
        String payid = idtext.getText();
        String  empid= empidtxt.getText();
        String date = datetxt.getValue().toString();
        double basic = Double.parseDouble(basicsaltxt.getText());
        double addon = Double.parseDouble(addontxt.getText());
        double text = Double.parseDouble(cutoffstxt.getText());
        double total = Double.parseDouble(totsaltxt.getText());


        EmployeeExpencesDto dto = new EmployeeExpencesDto(payid,empid,date,basic,addon,text,total);

        try {
            boolean update = model.update(dto);
            if(update){
                new Alert(Alert.AlertType.INFORMATION,"Employee Expences Successfully Updated").show();
                loadTbl();
                refresh();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR);
            e.printStackTrace();
        }


    }

    @FXML
    void addEmp(ActionEvent event) {
        String payid = idtext.getText();
        String  empid= empidtxt.getText();
        String date = datetxt.getValue().toString();
        double basic = Double.parseDouble(basicsaltxt.getText());
        double addon = Double.parseDouble(addontxt.getText());
        double text = Double.parseDouble(cutoffstxt.getText());
        double total = Double.parseDouble(totsaltxt.getText());

        EmployeeExpencesDto dto = new EmployeeExpencesDto(payid,empid,date,basic,addon,text,total);

        try {
            boolean save = model.save(dto);
            if(save){
                new Alert(Alert.AlertType.INFORMATION,"Employee Expences Successfully Added").show();
                loadTbl();
                refresh();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void deleteEmp(ActionEvent event) {
        EmployeeExpencesDto dto = new EmployeeExpencesDto();
        dto.setPaymentId(idtext.getText());

        try {
            boolean delete = model.delete(dto);
            if(delete){
                new Alert(Alert.AlertType.INFORMATION,"Employee Expences Successfully Deleted").show();
                loadTbl();
                refresh();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }

    private void refresh() {
        idtext.setText("");
        empidtxt.setText("");
        datetxt.setValue(null);
        basicsaltxt.setText("");
        addontxt.setText("");
        cutoffstxt.setText("");
        totsaltxt.setText("");

        try {
            getnxtId();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"cannot reload Id");
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

    @FXML
    void tabelclicked(MouseEvent event) {
        EmployeeExpencessTM selectedItem = salarytbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            idtext.setText(selectedItem.getPaymentId());
            empidtxt.setText(selectedItem.getEmployeeId());
            datetxt.setValue(LocalDate.parse(selectedItem.getDate()));
            basicsaltxt.setText(String.valueOf(selectedItem.getBasic()));
            addontxt.setText(String.valueOf(selectedItem.getAddons()));
            cutoffstxt.setText(String.valueOf(selectedItem.getTotal()));
            totsaltxt.setText(String.valueOf(selectedItem.getTotal()));
        }
    }
    public void getnxtId() throws SQLException {
        String id = model.getnextId();
        idtext.setText(id);
        System.out.println(id);
    }

}

