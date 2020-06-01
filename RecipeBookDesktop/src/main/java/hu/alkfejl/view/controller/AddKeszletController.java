package hu.alkfejl.view.controller;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.controller.KeszletController;
import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.model.Keszlet;
import hu.alkfejl.utils.utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddKeszletController {

    @FXML
    ComboBox<String> alapanyagChocie;

    @FXML
    ChoiceBox<String> mertekegysegChoice;

    @FXML
    TextField mennyiseg;

    @FXML
    TextField minimalis;

    List<Alapanyag> alapanyagList = AlapanyagController.getInstance().Osszes();


    public List<String> alapanyagNevek(List<Alapanyag> a){
        List<String> result = new ArrayList<>();
        for(int next = 0; next <= a.size()-1; next++){
            result.add(a.get(next).getNev());
        }
        return result;
    }

    public void initialize(){
        alapanyagChocie.getItems().addAll(alapanyagNevek(alapanyagList));
        mertekegysegChoice.getItems().addAll("kg", "dkg", "g", "evőkanál", "teáskanál", "kávéskanál", "l", "dl", "csipet");
    }

    public AddKeszletController(){}

    @FXML
    private void save(ActionEvent event) {
        String alap = alapanyagChocie.getValue();
        String mertekegyseg = mertekegysegChoice.getValue();

        if (alap.isEmpty()) {
            utils.showWarning("Nem lehet üres a név!");
            return;
        }
        if (mertekegyseg.isEmpty()) {
            utils.showWarning("Nem lehet üres a mértékegység!");
            return;
        }
        if(mennyiseg.getText().isEmpty()){
            utils.showWarning("Nem lehet üres a mennyiség!");
            return;
        }
        if(minimalis.getText().isEmpty()){
            utils.showWarning("Nem lehet üres a minimális késlet megadás!");
        }
        double menny = Double.parseDouble(mennyiseg.getText());
        double min = Double.parseDouble(minimalis.getText());
        Keszlet k = new Keszlet(alap, mertekegyseg, menny, min);

        if (KeszletController.getInstance().hozzaad(k)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } else {
            utils.showWarning("Nem sikerült a mentés!");
            return;
        }
    }

 }
