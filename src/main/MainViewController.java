package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Label lblStatus;

    @FXML
    void initialize() {
    }

    public void closeApp(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void handleLoginViewButtonAction(ActionEvent actionEvent) throws IOException {
        // Will open new scene but stage remain the same
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("../login/LoginView.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(loginViewParent));
        window.show();
    }

    public void handleComboBoxViewButtonAction(ActionEvent actionEvent) throws IOException {
        // Will open new stage
        Parent comboBoxViewParent = FXMLLoader.load(getClass().getResource("../combobox/ComboBoxView.fxml"));
        Stage window = new Stage();
        window.setTitle("ComboBox");
        window.setScene(new Scene(comboBoxViewParent));
        window.show();
    }

    public void handleCheckBoxViewButtonAction(ActionEvent actionEvent) throws IOException {
        Parent comboBoxViewParent = FXMLLoader.load(getClass().getResource("../checkbox/CheckBoxView.fxml"));
        Stage window = new Stage();
        window.setTitle("CheckBox");
        window.setScene(new Scene(comboBoxViewParent));
        window.show();
    }

    public void handleTableViewButtonAction(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../table/TableView.fxml"));
        Stage window = new Stage();
        window.setTitle("TableView");
        window.setScene(new Scene(tableViewParent));
        window.show();
    }

    public void handleAlertButtonAction(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../alertbox/AlertView.fxml"));
        Stage window = new Stage();
        window.setTitle("Alert");
        window.setScene(new Scene(tableViewParent));
        window.show();
    }
}
