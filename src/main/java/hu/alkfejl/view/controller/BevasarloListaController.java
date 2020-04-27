package hu.alkfejl.view.controller;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.controller.KeszletController;
import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.model.Keszlet;
import hu.alkfejl.utils.utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BevasarloListaController {

    @FXML
    ComboBox<String> alapanyagCh;

    @FXML
    ComboBox<String> mertekegysegCh;

    @FXML
    TextField mennyisegFd;

    List<Alapanyag> alapanyagList = AlapanyagController.getInstance().Osszes();

    public List<String> alapanyagNevek(List<Alapanyag> a){
        List<String> result = new ArrayList<>();
        for(int next = 0; next <= a.size()-1; next++){
            result.add(a.get(next).getNev());
        }
        return result;
    }

    public void initialize(){
        alapanyagCh.getItems().addAll(alapanyagNevek(alapanyagList));
        mertekegysegCh.getItems().addAll("kg", "dkg", "g", "evőkanál", "teáskanál", "kávéskanál", "l", "dl", "csipet");
    }

    @FXML
    public void megvettem(ActionEvent event){
        String alap = alapanyagCh.getValue();
        String mertek = mertekegysegCh.getValue();


        if (alap.isEmpty()) {
            utils.showWarning("Nem lehet üres a név!");
            return;
        }
        if (mertek.isEmpty()) {
            utils.showWarning("Nem lehet üres a mértékegység!");
            return;
        }
        if(mennyisegFd.getText().isEmpty()){
            utils.showWarning("Nem lehet üres a mennyiség!");
            return;
        }


        Double menny = Double.parseDouble(mennyisegFd.getText());
        Keszlet uj = KeszletController.getInstance().keres(alap);
        String nev = uj.getNev();
        double current = uj.getMennyiseg();
        System.out.println("Név" + nev);

        if (KeszletController.getInstance().modosit(menny+current, nev)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } else {
            utils.showWarning("Nem sikerült a mentés!");
            return;
        }
    }

    @FXML
    public void openAddAlapanyag(){
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

}
