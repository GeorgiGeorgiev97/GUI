package helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.function.Consumer;

public class Message {
    /**
     * Show an error message
     * @param title Title of the message
     * @param text Text of the message
     */
    public static void showError(String title, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(text);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.OK);
        alert.showAndWait();
    }


}
