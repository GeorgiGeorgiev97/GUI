import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        openDialog("anwendung", "Benutzerverwaltung");
        openDialog("login", "Benutzerverwaltung");
        openDialog("anmeldung", "Benutzerverwaltung");

    }

        public void openDialog(String name, String title) throws IOException{
            FXMLLoader loader = new FXMLLoader();
            InputStream loc = getClass().getClassLoader()
                .getResourceAsStream("resources/" + name + ".fxml");

        Parent root = (Parent) loader.load(loc);

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

}
