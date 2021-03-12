package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AnwendungsController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {  }

    @FXML
    public void cancel(ActionEvent e) {
        System.out.println("Abbrechen");
        Stage stage = (Stage) ((Button)e.getSource()).getScene().getWindow();
        stage.close();
    }
}

