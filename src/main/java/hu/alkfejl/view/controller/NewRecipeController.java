package hu.alkfejl.view.controller;

import hu.alkfejl.controller.ReceptController;
import hu.alkfejl.model.Recept;
import hu.alkfejl.utils.utils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class NewRecipeController {
    @FXML
    TextField nevCol;

    @FXML
    TextField idotartamCol;

    @FXML
    TextField foCol;

    @FXML
    ComboBox<String> nehezsegChoice;

    @FXML
    ComboBox<String> kategoriaChoice;

    @FXML
    TextArea leirasCol;

    @FXML
    TextArea alapanyagCol;


    public void initialize(){
        nehezsegChoice.getItems().addAll("Kezdőknek is", "Haladó szakácsoknak", "Csak profiknak ajánljuk");
        kategoriaChoice.getItems().addAll("Köret", "Főétel", "Leves", "Reggeli", "Nasi", "Sütemény", "Saláta", "Vega");
    }

    public NewRecipeController(){};

    @FXML
    private void save(ActionEvent event){
        String nehezseg = nehezsegChoice.getValue();
        String kategoria = kategoriaChoice.getValue();

        if(nevCol.getText().isEmpty()){
            utils.showWarning("Nem lehet üres a név!");
        }
        if(idotartamCol.getText().isEmpty()){
            utils.showWarning("Nem lehet üres az időtartam!");
        }
        if(foCol.getText().isEmpty()){
            utils.showWarning("Nem lehet üres a fő!");
        }
        if(nehezseg.isEmpty()){
            utils.showWarning("Meg kell adni a nehézséget!");
        }
        if(kategoria.isEmpty()){
            utils.showWarning("Meg kell adni a kategóriát!");
        }
        if(alapanyagCol.getText().isEmpty()){
            utils.showWarning("Meg kell adni az alapanyagokat!");
        }
        if(leirasCol.getText().isEmpty()){
            utils.showWarning("Meg kell írni az elkészítés módját!");
        }

        double ido = Double.parseDouble(idotartamCol.getText());
        int fo = Integer.parseInt(foCol.getText());

        Recept r = new Recept(nevCol.getText(), leirasCol.getText(), nehezseg, ido, fo, alapanyagCol.getText(), kategoria);

            if (ReceptController.getInstance().hozzaad(r)) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

            } else {
                utils.showWarning("Nem sikerült a mentés!");

                return;
            }

        }

}
