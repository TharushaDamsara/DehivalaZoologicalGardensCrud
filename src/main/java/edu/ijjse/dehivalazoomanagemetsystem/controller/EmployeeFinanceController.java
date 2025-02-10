package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.EmployeeExpencessTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.EmpExpencessDaoImpl;
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
                setEmpIds();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.toString(), ButtonType.OK).show();
            }
        }

    private void setEmpIds() {
        try {
            ArrayList<String> employeeIds = model.getEmployeeIds();
            ObservableList<String> ids = FXCollections.observableArrayList();
            ids.addAll(employeeIds);
            empIdtxt.setItems(ids);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Employee could not load", ButtonType.OK).show();
        }


    }

    private void loadTbl() throws SQLException {
        ArrayList<EmployeeExpencesDto> employeeExpenceDtos = model.getAll();
        ObservableList<EmployeeExpencessTM> employeeExpencessTMS = FXCollections.observableArrayList();

        for (EmployeeExpencesDto employeeExpencesdDto : employeeExpenceDtos) {
            EmployeeExpencessTM employeeExpencessTM = new EmployeeExpencessTM(
                    employeeExpencesdDto.getPaymentId(),
                    employeeExpencesdDto.getEmployeeId(),
                    employeeExpencesdDto.getDate(),
                    employeeExpencesdDto.getBasicSalary(),
                    employeeExpencesdDto.getAddonSalary(),
                    employeeExpencesdDto.getCutOffSalary(),
                    employeeExpencesdDto.getTotalSalary()
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
    private JFXComboBox<String> empIdtxt;
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

//    EmpExpencessDaoImpl model = new EmpExpencessDaoImpl();
EmpExpencessBo model = (EmpExpencessBo) BOFactory.getInstance().getBOType(BOFactory.BOType.EmpExpencess);

    @FXML
    void UpdateEmp(ActionEvent event) {
        String payid = idtext.getText();
        String  empid= empIdtxt.getValue();
        String date = datetxt.getValue().toString();
        double basic = Double.parseDouble(basicsaltxt.getText());
        double addon = Double.parseDouble(addontxt.getText());
        double text = Double.parseDouble(cutoffstxt.getText());
        double total = Double.parseDouble(totsaltxt.getText());

        idtext.setStyle(idtext.getStyle() + ";-fx-border-color: #7367F0;");
        empIdtxt.setStyle(empIdtxt.getStyle() + ";-fx-border-color: #7367F0;");
        datetxt.setStyle(datetxt.getStyle() + ";-fx-border-color: #7367F0;");
        basicsaltxt.setStyle(basicsaltxt.getStyle() + ";-fx-border-color: #7367F0;");
        addontxt.setStyle(addontxt.getStyle() + ";-fx-border-color: #7367F0;");
        cutoffstxt.setStyle(cutoffstxt.getStyle() + ";-fx-border-color: #7367F0;");
        totsaltxt.setStyle(totsaltxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean IsBasicValidSalary = RegexUtill.IsValidSalary(basicsaltxt.getText());
        boolean  ISAddonValid = RegexUtill.IsValidSalary(addontxt.getText());
        boolean IsCutoffValid = RegexUtill.IsValidSalary(cutoffstxt.getText());
        boolean isTotalValid = RegexUtill.IsValidSalary(totsaltxt.getText());

        if (!IsBasicValidSalary){
            basicsaltxt.setStyle(basicsaltxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!ISAddonValid){
            addontxt.setStyle(addontxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!IsCutoffValid){
            cutoffstxt.setStyle( cutoffstxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isTotalValid){
            totsaltxt.setStyle(totsaltxt.getStyle() + ";-fx-border-color: red;");
        }
        if (IsBasicValidSalary&ISAddonValid&IsCutoffValid&isTotalValid) {

            EmployeeExpencesDto dto = new EmployeeExpencesDto(payid, empid, date, basic, addon, text, total);

            try {
                boolean update = model.update(dto);
                if (update) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee Expences Successfully Updated").show();
                    loadTbl();
                    refresh();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        }

    }

    @FXML
    void addEmp(ActionEvent event) {
        String payid = idtext.getText();
        String  empid= empIdtxt.getValue();
        String date = datetxt.getValue().toString();
        double basic = Double.parseDouble(basicsaltxt.getText());
        double addon = Double.parseDouble(addontxt.getText());
        double text = Double.parseDouble(cutoffstxt.getText());
        double total = Double.parseDouble(totsaltxt.getText());

        idtext.setStyle(idtext.getStyle() + ";-fx-border-color: #7367F0;");
        empIdtxt.setStyle(empIdtxt.getStyle() + ";-fx-border-color: #7367F0;");
        datetxt.setStyle(datetxt.getStyle() + ";-fx-border-color: #7367F0;");
        basicsaltxt.setStyle(basicsaltxt.getStyle() + ";-fx-border-color: #7367F0;");
        addontxt.setStyle(addontxt.getStyle() + ";-fx-border-color: #7367F0;");
        cutoffstxt.setStyle(cutoffstxt.getStyle() + ";-fx-border-color: #7367F0;");
        totsaltxt.setStyle(totsaltxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean IsBasicValidSalary = RegexUtill.IsValidSalary(basicsaltxt.getText());
        boolean  ISAddonValid = RegexUtill.IsValidSalary(addontxt.getText());
        boolean IsCutoffValid = RegexUtill.IsValidSalary(cutoffstxt.getText());
        boolean isTotalValid = RegexUtill.IsValidSalary(totsaltxt.getText());

        if (!IsBasicValidSalary){
            basicsaltxt.setStyle(basicsaltxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!ISAddonValid){
            addontxt.setStyle(addontxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!IsCutoffValid){
            cutoffstxt.setStyle( cutoffstxt.getStyle() + ";-fx-border-color: red;");
        }
        if (!isTotalValid){
            totsaltxt.setStyle(totsaltxt.getStyle() + ";-fx-border-color: red;");
        }
        if (IsBasicValidSalary&ISAddonValid&IsCutoffValid&isTotalValid){
            EmployeeExpencesDto dto = new EmployeeExpencesDto(payid,empid,date,basic,addon,text,total);

            try {
                boolean save = model.add(dto);
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


    }

    @FXML
    void deleteEmp(ActionEvent event) {
        EmployeeExpencesDto dto = new EmployeeExpencesDto();
        dto.setPaymentId(idtext.getText());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee Expences Successfully Deleted").show();
                    loadTbl();
                    refresh();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Employee Expences Failed").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        }

    }

    private void refresh() {
        idtext.setText("");
        empIdtxt.getSelectionModel().clearSelection();
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
            empIdtxt.setValue(selectedItem.getEmployeeId());
            datetxt.setValue(LocalDate.parse(selectedItem.getDate()));
            basicsaltxt.setText(String.valueOf(selectedItem.getBasic()));
            addontxt.setText(String.valueOf(selectedItem.getAddons()));
            cutoffstxt.setText(String.valueOf(selectedItem.getTotal()));
            totsaltxt.setText(String.valueOf(selectedItem.getTotal()));
        }
    }
    public void getnxtId() throws SQLException {
        String id = model.getNextId();
        idtext.setText(id);
        System.out.println(id);
    }

    public void getTotal(ActionEvent actionEvent) {
        double basic = Double.parseDouble(basicsaltxt.getText());
        double addon = Double.parseDouble(addontxt.getText());
        double cutoff = Double.parseDouble(cutoffstxt.getText());
        double total = basic+addon-cutoff;

        totsaltxt.setText(String.valueOf(total));
        System.out.println(totsaltxt.getText());

    }
}

