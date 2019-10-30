package main;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {
    @FXML
    private Label lblStatus;

    @FXML
    private Button loginViewButton;

    @FXML
    void initialize() {
    }

    public void LoginView(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../login/LoginView.fxml"));
        primaryStage.setTitle("Login view");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }
}
