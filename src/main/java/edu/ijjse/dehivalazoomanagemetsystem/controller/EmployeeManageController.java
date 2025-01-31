package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EmpMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.model.tm.EmplyeeTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.EmpMngDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class EmployeeManageController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empidclm.setCellValueFactory(new PropertyValueFactory<>("empId"));
        empNameclm.setCellValueFactory(new PropertyValueFactory<>("name"));
        sallaryclm.setCellValueFactory(new PropertyValueFactory<>("salary"));
        addressclm.setCellValueFactory(new PropertyValueFactory<>("address"));
        devisionidclm.setCellValueFactory(new PropertyValueFactory<>("divisionId"));
        ageclm.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderclm.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthdayclm.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        jobclm.setCellValueFactory(new PropertyValueFactory<>("job"));
        contactclm.setCellValueFactory(new PropertyValueFactory<>("contact"));
   try {
       tabelLoad();
       getnextId();
   } catch (Exception e) {
       new Alert(Alert.AlertType.ERROR,"Tabel could not be loaded").show();
   }


    }

    private void tabelLoad() throws SQLException {
        ArrayList<EmpMngDto> empMngDtos = model.getAll();
        ObservableList<EmplyeeTM> employeeTms = FXCollections.observableArrayList();
        for (EmpMngDto empMngDto : empMngDtos) {
            EmplyeeTM emplyeeTM = new EmplyeeTM(
              empMngDto.getEmpId(),
              empMngDto.getEmpName(),
              empMngDto.getEmpSalary(),
              empMngDto.getEmpAddress(),
              empMngDto.getDivisionId(),
              empMngDto.getEmpAge(),
              empMngDto.getEmpGender(),
              empMngDto.getEmpBirth(),
              empMngDto.getEmpJob(),
              empMngDto.getEmpPhone()
            );
            employeeTms.add(emplyeeTM);
        }
        emptable.setItems(employeeTms);

    }

    @FXML
    private JFXButton addbtn;

    @FXML
    private TableColumn<EmplyeeTM, String> addressclm;

    @FXML
    private JFXTextField addresstxt;

    @FXML
    private TableColumn<EmplyeeTM,Integer> ageclm;

    @FXML
    private JFXTextField agetxt;

    @FXML
    private ImageView backIcon;

    @FXML
    private TableColumn<EmplyeeTM, String> birthdayclm;

    @FXML
    private TableColumn<EmplyeeTM, String> contactclm;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private DatePicker dobtxt;

    @FXML
    private AnchorPane empManagepane;

    @FXML
    private TableColumn<EmplyeeTM, String> empNameclm;

    @FXML
    private TableColumn<EmplyeeTM, String> empidclm;

    @FXML
    private TableView<EmplyeeTM> emptable;

    @FXML
    private TableColumn<EmplyeeTM, String> genderclm;

    @FXML
    private JFXTextField gendertxt;

    @FXML
    private JFXTextField idtext;

    @FXML
    private TableColumn<EmplyeeTM, String> jobclm;

    @FXML
    private JFXTextField jobtxt;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private JFXTextField salarytxt;

    @FXML
    private TableColumn<EmplyeeTM, String> sallaryclm;

    @FXML
    private ImageView searchIcon;

    @FXML
    private JFXTextField tptxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableColumn<EmplyeeTM, String> devisionidclm;

    @FXML
    private JFXTextField devisiontxt;

EmpMngDaoImpl model = new EmpMngDaoImpl();
    @FXML
    void UpdateEmp(ActionEvent event) {
        String id = idtext.getText();
        String name = nametxt.getText();
        double salary = Double.parseDouble(salarytxt.getText());
        String address = addresstxt.getText();
        String devision = devisiontxt.getText();
        int age = Integer.parseInt(agetxt.getText());
        String gender = gendertxt.getText();
        String dob = String.valueOf(dobtxt.getValue());
        String job = jobtxt.getText();
        String cntact = tptxt.getText();

        EmpMngDto empMngDto = new EmpMngDto(id,name,salary,address,devision,age,gender,dob,job,cntact);
        try {
            boolean update = model.update(empMngDto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION,"Employee updated successfully").show();
                tabelLoad();
                clearForm();
                getnextId();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Database could not be updated").show();
        }

    }

    private void getnextId() throws SQLException {
        String nextId = model.getNextId();
        idtext.setText(nextId);
    }

    @FXML
    void addEmp(ActionEvent event) {
        String id = idtext.getText();
        String name = nametxt.getText();
        double salary = Double.parseDouble(salarytxt.getText());
        String address = addresstxt.getText();
        String devision = devisiontxt.getText();
        int age = Integer.parseInt(agetxt.getText());
        String gender = gendertxt.getText();
        String dob = String.valueOf(dobtxt.getValue());
        String job = jobtxt.getText();
        String cntact = tptxt.getText();

        EmpMngDto empMngDto = new EmpMngDto(id,name,salary,address,devision,age,gender,dob,job,cntact);
        try {
            boolean add = model.add(empMngDto);
            if (add){
                new Alert(Alert.AlertType.INFORMATION,"Added Successfully").show();
                tabelLoad();
                clearForm();
                getnextId();
            }


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Employee could not be added"+e.toString()).show();
            e.printStackTrace();
        }

    }

    private void clearForm() {
    idtext.setText("");
    nametxt.setText("");
    salarytxt.setText("");
    addresstxt.setText("");
    devisiontxt.setText("");
    agetxt.setText("");
    gendertxt.setText("");
    dobtxt.setValue(null);
    jobtxt.setText("");
    tptxt.setText("");

    }

    @FXML
    void deleteEmp(ActionEvent event) {
    EmpMngDto empMngDto = new EmpMngDto();
    empMngDto.setEmpId(idtext.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(empMngDto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully").show();
                    tabelLoad();
                    clearForm();
                    getnextId();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Employee could not be deleted" + e.toString()).show();
            }
        }
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        empManagepane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        empManagepane.getChildren().add(load);
    }

    @FXML
    void search(MouseEvent event) {

    }

    @FXML
    void getdetails(MouseEvent event) {

    EmplyeeTM emplyeeTM = emptable.getSelectionModel().getSelectedItem();
    if (emplyeeTM != null) {
        idtext.setText(emplyeeTM.getEmpId());
        nametxt.setText(emplyeeTM.getName());
        salarytxt.setText(String.valueOf(emplyeeTM.getSalary()));
        addresstxt.setText(emplyeeTM.getAddress());
        devisiontxt.setText(emplyeeTM.getDivisionId());
        agetxt.setText(String.valueOf(emplyeeTM.getAge()));
        gendertxt.setText(emplyeeTM.getGender());
        dobtxt.setValue(LocalDate.parse(emplyeeTM.getBirthday()));
        jobtxt.setText(emplyeeTM.getJob());
        tptxt.setText(emplyeeTM.getContact());


    }
    }

}
