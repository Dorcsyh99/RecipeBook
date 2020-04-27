package hu.alkfejl.view.controller;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.utils.utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlapanyagHozzaadasa {

    @FXML
    TextField nevField;
    @FXML
    TextField mertekegysegField;



    public AlapanyagHozzaadasa() {

    }

    @FXML
    private void save(ActionEvent event) {
        if (nevField.getText().isEmpty()) {
            utils.showWarning("A név nem lehet üres!");

            return;
        }
        if (mertekegysegField.getText().isEmpty()) {
            utils.showWarning("A mértékegység nem lehet üres!");

            return;
        }
        Alapanyag a = new Alapanyag(nevField.getText(), mertekegysegField.getText());

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
