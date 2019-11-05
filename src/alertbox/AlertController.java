package alertbox;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertController {
    public void handleAlertButtonAction(ActionEvent actionEvent) {
        String contentText = "Are you sure you want to delete this task?";
        Alert alert = new Alert(Alert.AlertType.WARNING, contentText, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.setTitle("Custom title");
//        alert.setHeaderText("header text");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff
        }
    }
}
