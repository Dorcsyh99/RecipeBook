package hu.alkfejl;

import hu.alkfejl.controller.AlapanyagController;
import hu.alkfejl.model.Alapanyag;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class App extends Application{
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/main_window.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
