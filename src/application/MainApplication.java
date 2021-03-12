package application;

import classes.*;
import controllers.ReferenceController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import static javafx.application.Application.launch;


public class MainApplication extends Application {
    private BenutzerVerwaltungAdmin admin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        admin = new BenutzerVerwaltungAdmin();


        int dbInitialisieren;
        do {
            System.out.print("Soll die Benutzerverwaltung neu initialisiert werden? (Ja = 1; Nein = 0) ");
            BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
            dbInitialisieren = Integer.parseInt(din.readLine());
        } while (dbInitialisieren != 0 && dbInitialisieren != 1);

        if (dbInitialisieren == 1) {
            admin.dbInit();
            System.out.println("Die Benutzerverwaltung wird initialisiert.");
        } else if(dbInitialisieren == 0) {
            System.out.println("Die Benutzerverwaltung wird nicht initialisiert.");
        }



        openDialog("login", "Benutzerverwaltung");

    }

    /**
     * Load Window From FXML
     * @param name fxml name
     * @param title Window title

     */
    private void openDialog(String name, String title) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Parent) loader.load(getClass().getClassLoader()
                    .getResourceAsStream("resources/" + name + ".fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

            if (loader.getController() instanceof ReferenceController) {
                ((ReferenceController) loader.getController()).setReference(this);
            }
        } catch (IOException e) {}
    }


    /**
     * Open create user dialog
     */
    public void neuAnmeldung() {
        openDialog("anmeldung", "Benutzerverwaltung");
    }

    /**
     * Create new user
     * @param b User
     * @throws UserAlreadyExistsException Throw error if user already exists
     */
    public void neuerBenutzer(Benutzer b) throws UserAlreadyExistsException, EmptyUser {
        try {
            admin.benutzerEintragen(b);
            openDialog("login", "Benutzerverwaltung");
        } catch (UserAlreadyExistsException e ) {
            throw new UserAlreadyExistsException("You cannot add user because the user already exists.");
        } catch (EmptyUser e){
            throw new EmptyUser("You cannot login because the user is empty.");
        }
    }

    /**
     * Show application if login sucessful
     * @param b User
     * @throws UserNotFoundException Throw error is user does not exists
     */
    public void benutzerLogin(Benutzer b) throws UserNotFoundException {
        if (admin.benutzerVorhanden(b)) {
            openDialog("anwendung", "Benutzerverwaltung");
        } else {
            throw new UserNotFoundException("You cannot login because the user does not exist.");
        }
    }
}
