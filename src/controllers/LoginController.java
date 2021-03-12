package controllers;

import application.MainApplication;
import classes.Benutzer;
import classes.UserNotFoundException;
import helpers.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends ReferenceController implements Initializable{

    @FXML
    TextField userID;
    @FXML
    PasswordField password;
    private boolean neuAnmeldung = false;


    //Wird aufgerufen, um einen Controller zu initialisieren,
    //nachdem sein Stammelement(Root) vollständig verarbeitet wurde
    @Override
    public void initialize(URL location, ResourceBundle resources) {}



    //Neue Anmeldung
    public void toggleNewLogin(ActionEvent e){
        neuAnmeldung = !neuAnmeldung;
        System.out.println("Neu Anmeldung: " + (neuAnmeldung ? "Ja" : "Nein"));
    }

    //Erzeugung eines Objekts der Klasse Benutzer
    public void execute(ActionEvent e){
        Benutzer user = new Benutzer(userID.getText(), password.getText().toCharArray());
        try{
            if(neuAnmeldung){
                mainApp.neuAnmeldung();
            }
            else {
                mainApp.benutzerLogin(user);
                System.out.println(user);
            }
            Stage stage = (Stage)((Button)e.getSource()).getScene().getWindow();
            stage.close();
        } catch (UserNotFoundException er){
            Message.showError("Login failed!", "Login failed, please check you credentials!");
        }
    }
}
