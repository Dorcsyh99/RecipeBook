package hu.alkfejl.view.controller;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.model.Alapanyag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import hu.alkfejl.utils.utils;

public class AlapanyagHozzaadasa {

    @FXML
    TextField nevField;
    @FXML
    ComboBox<String> mertekegysegChoice;



    public void initialize(){
        mertekegysegChoice.getItems().addAll("kg", "dkg", "g", "evőkanál", "teáskanál", "kávéskanál", "db", "l", "dl", "csipet");
    }
    public AlapanyagHozzaadasa() {

    }

    @FXML
    private void save(ActionEvent event) {
        String mertekegyseg = mertekegysegChoice.getValue().toString();
        if (nevField.getText().isEmpty()) {
            utils.showWarning("A név nem lehet üres!");

            return;
        }
        if (mertekegyseg.isEmpty()) {
            utils.showWarning("A mértékegység nem lehet üres!");

            return;
        }
        Alapanyag a = new Alapanyag(nevField.getText(), mertekegyseg);

        if (AlapanyagController.getInstance().hozzaad(a)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } else {
            utils.showWarning("Nem sikerült a mentés!");

            return;
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
