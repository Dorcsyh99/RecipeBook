package hu.alkfejl.view.controller;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.controller.KeszletController;
import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.model.Keszlet;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

     @FXML
     private TableView<Keszlet> table;

     @FXML
     private TableView<Alapanyag> table2;

     @FXML
     private TableColumn<Keszlet, String> nevCol;

     @FXML
     private TableColumn<Keszlet, String> mertekegysegCol;

     @FXML
     private TableColumn<Keszlet, Double> keszletenCol;

     @FXML
     private TableColumn<Alapanyag, String> alapNev;

     @FXML
     private TableColumn<Alapanyag, String> alapMert;

     @FXML
     private TableColumn<Keszlet, Double> minCol;

     @FXML
     public void refreshKeszlet(){
         List<Keszlet> list = KeszletController.getInstance().Osszes();
         table.setItems(FXCollections.observableArrayList(list));
     }

     @FXML
     public void refreshAlapanyagok(){
         List<Alapanyag> list = AlapanyagController.getInstance().Osszes();
         table2.setItems(FXCollections.observableArrayList(list));
     }

     @FXML
     public void addAlapanyag(){
         Parent root = null;
         try {
             root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/add_dialog.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.showAndWait();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     @FXML
     public void openMenus(){
         Parent root = null;
         try {
             root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/weekly_menu.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.showAndWait();
         } catch (IOException e){
             e.printStackTrace();
         }
     }

     @FXML
     public void openReceptek(){
         Parent root = null;
         try {
             root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/receptek.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.show();
         } catch (IOException e){
             e.printStackTrace();
         }
     }
    @FXML
    public void openLista(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/lista.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

     @FXML
     public void openKeszletModositas(){
         Parent root = null;
         try {
             root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/add_keszlet.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.showAndWait();
         } catch (IOException e){
             e.printStackTrace();
         }
     }

    public MainWindowController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Keszlet> list = KeszletController.getInstance().Osszes();
        table.setItems(FXCollections.observableArrayList(list));

        nevCol.setCellValueFactory(new PropertyValueFactory<>("alapanyagNev"));
        mertekegysegCol.setCellValueFactory(new PropertyValueFactory<>("alapanyagMertekegyseg"));
        keszletenCol.setCellValueFactory(new PropertyValueFactory<>("mennyiseg"));
        minCol.setCellValueFactory(new PropertyValueFactory<>("minimalis"));

        List<Alapanyag> list2 = AlapanyagController.getInstance().Osszes();
        table2.setItems(FXCollections.observableArrayList(list2));

        alapNev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        alapMert.setCellValueFactory(new PropertyValueFactory<>("mertekegyseg"));

    }
}

