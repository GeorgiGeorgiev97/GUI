package controllers;

import classes.Benutzer;
import classes.EmptyUser;
import classes.UserAlreadyExistsException;
import helpers.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AnmeldungsController extends ReferenceController implements Initializable {
    @FXML
    TextField userID;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password_repeat;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    public void execute(ActionEvent e){
        if(this.password.getText().equals(this.password_repeat.getText())) {
            Benutzer user = new Benutzer(this.userID.getText(), this.password.getText().toCharArray());
            try{
            mainApp.neuerBenutzer(user);
            System.out.println(user);
            Stage stage = (Stage) userID.getScene().getWindow();
            stage.close();
        } catch (UserAlreadyExistsException | EmptyUser er){
            Message.showError("User could not be created!", "User could not be created, because it already exists.");
        }
    }
        else {
            Message.showError("Error occured!", "Passwords do not match.");
        }
    }
}

