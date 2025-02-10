package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.bo.BOFactory;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalDto;
import edu.ijjse.dehivalazoomanagemetsystem.tm.AnimalMngTM;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.AnimalMngDaoImpl;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.RegexUtill;
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

public class AnimalMngController implements Initializable {
 /**
  * @param url
  * @param resourceBundle
  */
 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
  idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
  namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
  agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
  gendercol.setCellValueFactory(new PropertyValueFactory<>("gender"));
  catogarycol.setCellValueFactory(new PropertyValueFactory<>("category"));
  enclosercol.setCellValueFactory(new PropertyValueFactory<>("enclosureId"));
  devisoncol.setCellValueFactory(new PropertyValueFactory<>("divisionId"));

     try {
         tabelload();
         nextAnimalId();
         getEnclosureId();
         getdivisionIds();

     } catch (SQLException e) {
         new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
     }
 }

    private void getdivisionIds() {
        try {
            ArrayList<String> division = animalMngBo.getDivision();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(division);
            devisiontxt.setItems(objects);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }


    }

    private void getEnclosureId() {
        try {
            ArrayList<String> enclosure = animalMngBo.getEnclosure();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(enclosure);
            enclosrtxt.setItems(objects);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    private void tabelload() throws SQLException {
  ArrayList<AnimalDto> animalDtos = animalMngBo.getAll();
//        System.out.println(animalDtos);
  ObservableList<AnimalMngTM> AnimalTms = FXCollections.observableArrayList();
for (AnimalDto animalDto : animalDtos) {
 AnimalMngTM animalMngTM = new AnimalMngTM(
   animalDto.getAnimalId(),
   animalDto.getAnimalName(),
    animalDto.getAnimalAge(),
    animalDto.getAnimalGender(),
    animalDto.getCatagory(),
    animalDto.getEnclosureId(),
    animalDto.getDivisionId()
 );
   AnimalTms.add(animalMngTM);
  }
animaltbl.setItems(AnimalTms);
 }

 @FXML
 private JFXButton addbtn;

 @FXML
 private TableColumn<AnimalMngTM, Double> agecol;

 @FXML
 private JFXTextField agetxt;

 @FXML
 private ImageView backbtn;

 @FXML
 private TableColumn<AnimalMngTM, String> catogarycol;

 @FXML
 private JFXTextField catogarytxt;

 @FXML
 private JFXButton deletebtn;

    @FXML
    private JFXComboBox<String> devisiontxt;

 @FXML
 private TableColumn<AnimalMngTM, String> devisoncol;

 @FXML
 private TableColumn<AnimalMngTM, String> enclosercol;
    @FXML
    private JFXComboBox<String> enclosrtxt;

 @FXML
 private JFXTextField gemdertxt;

 @FXML
 private TableColumn<AnimalMngTM, String> gendercol;

 @FXML
 private TableColumn<AnimalMngTM, String> idcol;

 @FXML
 private JFXTextField idtxt;

 @FXML
 private TableColumn<AnimalMngTM, String> namecol;

 @FXML
 private JFXTextField nametxt;

 @FXML
 private JFXButton reportbtn;

 @FXML
 private JFXButton updatebtn;
 @FXML
 private TableView<AnimalMngTM> animaltbl;

 AnimalMngBo animalMngBo = (AnimalMngBo) BOFactory.getInstance().getBOType(BOFactory.BOType.Animal);

    @FXML
    void Update(ActionEvent event) {
        String animalId = idtxt.getText();
        String name = nametxt.getText();
        double age = Double.parseDouble(agetxt.getText());
        String gender = gemdertxt.getText();
        String catogary = catogarytxt.getText();
        String encloser = enclosrtxt.getValue();
        String devision = devisiontxt.getValue();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        nametxt.setStyle(nametxt.getStyle() + ";-fx-border-color: #7367F0;");
        agetxt.setStyle(agetxt.getStyle() + ";-fx-border-color: #7367F0;");
        gemdertxt.setStyle(gemdertxt.getStyle() + ";-fx-border-color: #7367F0;");
        catogarytxt.setStyle(catogarytxt.getStyle() + ";-fx-border-color: #7367F0;");
        enclosrtxt.setStyle(enclosrtxt.getStyle() + ";-fx-border-color: #7367F0;");
        devisiontxt.setStyle(devisiontxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isvalidAge = RegexUtill.IsvalidAge(agetxt.getText());
        boolean isValidGender = RegexUtill.IsValidGender(gemdertxt.getText());

        if (!isvalidAge){
            agetxt.setStyle(agetxt.getStyle() + ";-fx-border-color: red;");
            System.out.println("not a valid age");
        }
        if (!isValidGender){
            gemdertxt.setStyle(gemdertxt.getStyle() + ";-fx-border-color: red;");
            return;
        }
        if (isValidGender&&isvalidAge){
            AnimalDto dto = new AnimalDto(animalId, name, age,gender, catogary, encloser, devision);
            try {
                boolean update = animalMngBo.update(dto);
                if (update) {
                    new Alert(Alert.AlertType.INFORMATION, "Animal Updated Successfully").show();
                    clearform();
                    tabelload();
                    nextAnimalId();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.toString()).show();
                e.printStackTrace();
            }
        }
    }

    @FXML
    void add(ActionEvent event) {
     String animalId = idtxt.getText();
     String name = nametxt.getText();
     double age = Double.parseDouble(agetxt.getText());
     String gender = gemdertxt.getText();
     String catogary = catogarytxt.getText();
     String encloser = enclosrtxt.getValue();
     String devision = devisiontxt.getValue();

        idtxt.setStyle(idtxt.getStyle() + ";-fx-border-color: #7367F0;");
        nametxt.setStyle(nametxt.getStyle() + ";-fx-border-color: #7367F0;");
        agetxt.setStyle(agetxt.getStyle() + ";-fx-border-color: #7367F0;");
        gemdertxt.setStyle(gemdertxt.getStyle() + ";-fx-border-color: #7367F0;");
        catogarytxt.setStyle(catogarytxt.getStyle() + ";-fx-border-color: #7367F0;");
        enclosrtxt.setStyle(enclosrtxt.getStyle() + ";-fx-border-color: #7367F0;");
        devisiontxt.setStyle(devisiontxt.getStyle() + ";-fx-border-color: #7367F0;");

        boolean isvalidAge = RegexUtill.IsvalidAge(agetxt.getText());
        boolean isValidGender = RegexUtill.IsValidGender(gemdertxt.getText());

        if (!isvalidAge){
            agetxt.setStyle(agetxt.getStyle() + ";-fx-border-color: red;");
            System.out.println("not a valid age");
        }
        if (!isValidGender){
            gemdertxt.setStyle(gemdertxt.getStyle() + ";-fx-border-color: red;");
            return;
        }
        if (isValidGender&&isvalidAge) {

            AnimalDto dto = new AnimalDto(animalId, name, age, gender, catogary, encloser, devision);
            try {
                boolean add = animalMngBo.add(dto);
                if (add) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Animal Added Successfully").show();
                    clearform();
                    tabelload();
                    nextAnimalId();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Input datas are Wrong").show();
                e.printStackTrace();
            }
        }

    }


    private void clearform() {
        idtxt.setText("");
        nametxt.setText("");
        agetxt.setText("");
        gemdertxt.setText("");
        catogarytxt.setText("");
        enclosrtxt.getSelectionModel().clearSelection();
        devisiontxt.getSelectionModel().clearSelection();
    }

    @FXML
    void delete(ActionEvent event) {
        AnimalDto dto = new AnimalDto();
        dto.setAnimalId(idtxt.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            try {
                boolean delete = animalMngBo.delete(dto);
                if (delete) {
                    new Alert(Alert.AlertType.INFORMATION, "Animal Deleted Successfully").show();
                    tabelload();
                    clearform();
                    nextAnimalId();
                }
                else {
                    new Alert(Alert.AlertType.ERROR, "Animal Not Deleted").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Input datas are Wrong ").show();
            }
        }
    }

    @FXML
    void genarateReport(ActionEvent event) throws IOException {
        Stage window = (Stage) addbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/HelthReport.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void goback(MouseEvent event) throws IOException, IOException {
        Stage window = (Stage) addbtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserFuntion.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();
    }


 @FXML
 void tableClicked(MouseEvent event) {
    AnimalMngTM animalMngTM = animaltbl.getSelectionModel().getSelectedItem();
    if (animalMngTM != null) {
     idtxt.setText(animalMngTM.getId());
     nametxt.setText(animalMngTM.getName());
     agetxt.setText(String.valueOf(animalMngTM.getAge()));
     gemdertxt.setText(animalMngTM.getGender());
     catogarytxt.setText(animalMngTM.getCategory());
     enclosrtxt.setValue(animalMngTM.getEnclosureId());
     devisiontxt.setValue(animalMngTM.getDivisionId());
    }
 }
 public void nextAnimalId() throws SQLException {
     String nextAnimalId = animalMngBo.getNextId();
     idtxt.setText(nextAnimalId);
 }
}
