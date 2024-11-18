package edu.ijjse.dehivalazoomanagemetsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.tm.AnimalMngTM;
import edu.ijjse.dehivalazoomanagemetsystem.model.AnimalMngModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

     } catch (SQLException e) {
         new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
     }
 }

 private void tabelload() throws SQLException {
  ArrayList<AnimalMngDto> animalMngDtos = model.getAll();
  ObservableList<AnimalMngTM> AnimalTms = FXCollections.observableArrayList();
for (AnimalMngDto animalMngDto : animalMngDtos) {
 AnimalMngTM animalMngTM = new AnimalMngTM(
   animalMngDto.getAnimalId(),
   animalMngDto.getAnimalName(),
    animalMngDto.getAnimalAge(),
    animalMngDto.getAnimalGender(),
    animalMngDto.getCatagory(),
    animalMngDto.getEnclosureId(),
    animalMngDto.getDivisionId()
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
 private JFXTextField devisiontxt;

 @FXML
 private TableColumn<AnimalMngTM, String> devisoncol;

 @FXML
 private TableColumn<AnimalMngTM, String> enclosercol;

 @FXML
 private JFXTextField enclosrtxt;

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

 AnimalMngModel model = new AnimalMngModel();

    @FXML
    void Update(ActionEvent event) {
        String animalId = idtxt.getText();
        String name = nametxt.getText();
        double age = Double.parseDouble(agetxt.getText());
        String gender = gemdertxt.getText();
        String catogary = catogarytxt.getText();
        String encloser = enclosrtxt.getText();
        String devision = devisiontxt.getText();


        AnimalMngDto dto = new AnimalMngDto(animalId, name, age,gender, catogary, encloser, devision);
        try {
            boolean update = model.update(dto);
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

    @FXML
    void add(ActionEvent event) {
     String animalId = idtxt.getText();
     String name = nametxt.getText();
     double age = Double.parseDouble(agetxt.getText());
     String gender = gemdertxt.getText();
     String catogary = catogarytxt.getText();
     String encloser = enclosrtxt.getText();
     String devision = devisiontxt.getText();


     AnimalMngDto dto = new AnimalMngDto(animalId, name, age,gender, catogary, encloser, devision);
        try {
            boolean add = model.add(dto);
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


    private void clearform() {
        idtxt.setText("");
        nametxt.setText("");
        agetxt.setText("");
        gemdertxt.setText("");
        catogarytxt.setText("");
        enclosrtxt.setText("");
        devisiontxt.setText("");
    }

    @FXML
    void delete(ActionEvent event) {
        AnimalMngDto dto = new AnimalMngDto();
        dto.setAnimalId(idtxt.getText());
        try {
            boolean delete = model.delete(dto);
            if (delete) {
                new Alert(Alert.AlertType.INFORMATION, "Animal Deleted Successfully").show();
                tabelload();
                clearform();
                nextAnimalId();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Input datas are Wrong ").show();
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
     enclosrtxt.setText(animalMngTM.getEnclosureId());
     devisiontxt.setText(animalMngTM.getDivisionId());
    }
 }
 public void nextAnimalId() throws SQLException {
     String nextAnimalId = model.getNextAnimalId();
     idtxt.setText(nextAnimalId);
 }
}
