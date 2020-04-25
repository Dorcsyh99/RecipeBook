package hu.alkfejl.view.controller;

import hu.alkfejl.controller.ReceptController;
import hu.alkfejl.model.Recept;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReceptekController implements Initializable {

    @FXML
    HBox hbox;

    List<Recept> receptLista = ReceptController.getInstance().Osszes();

    public String[] alapanyagSplit(Recept r){
        String[] alapanyagok;
        alapanyagok = r.getAlapanyagok().split(",");
        return alapanyagok;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

        List<TitledPane> paneList = new ArrayList<>();
        Label hozzavalok = new Label("Hozzávalók:");
        Label elkeszites = new Label("Elkészítés:");
        ListView<String> alapok = new ListView<>();


        for(int next = 0; next <= receptLista.size()-1; ++next){
            GridPane grid = new GridPane();
            TitledPane pane = new TitledPane();
            pane.setText(receptLista.get(next).getNev());
            Label nehezseg = new Label("Nehézség: " + receptLista.get(next).getNehezseg());
            Label idotartam = new Label("Időtartam: " + receptLista.get(next).getIdotartam() + " perc");
            Label fo = new Label("Hány főnek: " + receptLista.get(next).getFo());
            Label kategoria = new Label("Kategória:" + receptLista.get(next).getKategoria());
            Text leiras = new Text(receptLista.get(next).getLeiras());
            ObservableList<String> items = FXCollections.observableArrayList(
                    alapanyagSplit(receptLista.get(next))
            );
            alapok.setItems(items);
            grid.add(nehezseg, 0, 0); //column = 1, row = 1
            grid.add(idotartam, 0, 1);
            grid.add(fo, 1, 0);
            grid.add(kategoria, 1, 1);
            grid.add(hozzavalok, 0, 2);
            grid.add(alapok, 1, 2);
            grid.add(elkeszites, 0, 3);
            grid.add(leiras, 1, 3);
            pane.setContent(grid);
            paneList.add(pane);
        }
        Accordion root = new Accordion();
        root.setPrefWidth(650);
        root.getPanes().addAll(paneList);

        hbox.getChildren().add(root);
    }

    @FXML
    public void new_recipe(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/new_recipe.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
