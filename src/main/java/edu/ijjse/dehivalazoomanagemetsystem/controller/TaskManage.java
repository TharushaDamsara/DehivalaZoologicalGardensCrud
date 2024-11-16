package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TaskDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.TaskMngTm;
import edu.ijjse.dehivalazoomanagemetsystem.model.TaskModel;
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

public class TaskManage implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     idcol.setCellValueFactory(new PropertyValueFactory<>("taskId"));
     empidcol.setCellValueFactory(new PropertyValueFactory<>("empId"));
     namecol.setCellValueFactory(new PropertyValueFactory<>("taskName"));
     datecol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

     loadTabel();
     getnextId();

    }

    private void loadTabel() {
        try {
            ArrayList<TaskDto> taskDtos = taskModel.getAll();
            ObservableList<TaskMngTm> taskMngTms = FXCollections.observableArrayList();
            for (TaskDto taskDto : taskDtos) {
                TaskMngTm taskMngTm = new TaskMngTm(
                        taskDto.getTaskId(),
                        taskDto.getEmpId(),
                        taskDto.getTaskName(),
                        taskDto.getDueDate()
                );
                taskMngTms.add(taskMngTm);
            }
            Tasktbl.setItems(taskMngTms);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }

    }

    @FXML
    private TableView<TaskMngTm> Tasktbl;

    @FXML
    private JFXButton addbtn;

    @FXML
    private ImageView backbtn;

    @FXML
    private TableColumn<TaskMngTm, String> datecol;

    @FXML
    private DatePicker datetxt;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private JFXTextField empIdtxt;

    @FXML
    private TableColumn<TaskMngTm, String> idcol;

    @FXML
    private JFXTextField idtxt;

    @FXML
    private TableColumn<TaskMngTm, String> namecol;

    @FXML
    private JFXTextField nametxt;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private TableColumn<TaskMngTm, String> empidcol;

    TaskModel taskModel = new TaskModel();

    @FXML
    void Update(ActionEvent event) {
        String id = idtxt.getText();
        String empId = empIdtxt.getText();
        String taskName = nametxt.getText();
        String date = String.valueOf(datetxt.getValue());

        TaskDto taskDto = new TaskDto(id, empId, taskName, date);
        try {
            boolean update = taskModel.update(taskDto);
            if (update) {
               new Alert(Alert.AlertType.INFORMATION,"Task updated successfully").show();
                loadTabel();
                clearAll();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Task update failed").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void clearAll() {
        idtxt.setText("");
        empIdtxt.setText("");
        nametxt.setText("");
        datetxt.setValue(null);

        getnextId();
    }

    private void getnextId() {
        try {
            String nextTaskId = taskModel.getNextTaskId();
            idtxt.setText(nextTaskId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void add(ActionEvent event) {
        String id = idtxt.getText();
        String empId = empIdtxt.getText();
        String taskName = nametxt.getText();
        String date = String.valueOf(datetxt.getValue());

        TaskDto taskDto = new TaskDto(id, empId, taskName, date);
        try {
            boolean add = taskModel.add(taskDto);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION,"Task added successfully").show();
                loadTabel();
                clearAll();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Task add failed").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }


    }

    @FXML
    void delete(ActionEvent event) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(idtxt.getText());
        try {
            boolean delete = taskModel.delete(taskDto);
            if (delete) {
                new Alert(Alert.AlertType.INFORMATION,"Task deleted successfully").show();
                loadTabel();
                clearAll();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Task delete failed").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
        Stage window = (Stage)backbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();


    }

    @FXML
    void tabelClicked(MouseEvent event) {
        TaskMngTm selectedItem = Tasktbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
           idtxt.setText(selectedItem.getTaskId());
            empIdtxt.setText(selectedItem.getEmpId());
            nametxt.setText(selectedItem.getTaskName());
            datetxt.setValue(LocalDate.parse(selectedItem.getDueDate()));
        }

    }

}
