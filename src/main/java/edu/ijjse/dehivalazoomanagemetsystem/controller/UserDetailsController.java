package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.UserDetailMngTM;
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

public class UserDetailsController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserIcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        empidcol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        usernamecol.setCellValueFactory(new PropertyValueFactory<>("username"));
        pwdcol.setCellValueFactory(new PropertyValueFactory<>("password"));

        try {
            loadtabel();
            getnxtId();
            loadUserIDs();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void loadUserIDs() {
        try {
            ArrayList<String> employeeIds = model.getEmployeeIds();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(employeeIds);
            empIdtxt.setItems(objects);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    @FXML
    private TableColumn<UserDetailMngTM, String> UserIcol;

    @FXML
    private JFXTextField UserNametxt;

    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private JFXComboBox<String> empIdtxt;


    @FXML
    private TableColumn<UserDetailMngTM, String> empidcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private JFXTextField pwdTxt;

    @FXML
    private TableColumn<UserDetailMngTM, String> pwdcol;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableColumn<UserDetailMngTM, String> usernamecol;

    @FXML
    private TableView<UserDetailMngTM> usertbl;
  UserDetailsBo model = (UserDetailsBo) BOFactory.getInstance().getBOType(BOFactory.BOType.UserDetails);

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String empId = empIdtxt.getValue();
        String userName = UserNametxt.getText();
        String pwd = pwdTxt.getText();
        UserDetailsDto dto = new UserDetailsDto(id, empId, userName, pwd);
        try {
            boolean update = model.update(dto);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION,"user aded successfully").show();
                refesh();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    private void refesh() throws SQLException {

    idtxt.setText("");
    empIdtxt.getSelectionModel().clearSelection();
    UserNametxt.setText("");
    pwdTxt.setText("");
    loadtabel();
    getnxtId();
    }

    private void getnxtId() {
        try {
            String nxtId = model.getNextId();
            idtxt.setText(nxtId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void loadtabel() throws SQLException {
        ArrayList<UserDetailsDto> userDetailDtos = model.getAll();
        ObservableList<UserDetailMngTM> userDetailMngTMS = FXCollections.observableArrayList();

        for (UserDetailsDto dto : userDetailDtos) {
            UserDetailMngTM userDetailMngTM = new UserDetailMngTM(
              dto.getUserId(),
              dto.getEmpId(),
              dto.getUserName(),
              dto.getPassword()
            );
            userDetailMngTMS.add(userDetailMngTM);
        }
        usertbl.setItems(userDetailMngTMS);
    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String empId = empIdtxt.getValue();
        String userName = UserNametxt.getText();
        String pwd = pwdTxt.getText();
        UserDetailsDto dto = new UserDetailsDto(id, empId, userName, pwd);
        try {
            boolean add = model.add(dto);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION,"user added successfully").show();
                refesh();
                getnxtId();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void delete(ActionEvent event) {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setUserId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = model.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "user deleted successfully").show();
                    refesh();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                e.printStackTrace();
            }
        }
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage) backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tabelClicked(MouseEvent event) {
        UserDetailMngTM selectedItem = usertbl.getSelectionModel().getSelectedItem();
      idtxt.setText(selectedItem.getId());
      empIdtxt.setValue(selectedItem.getEmpId());
      UserNametxt.setText(selectedItem.getUsername());
      pwdTxt.setText(selectedItem.getPassword());

    }

}
