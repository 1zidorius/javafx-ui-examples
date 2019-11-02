package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
        LoginModel loginViewModel = new LoginModel();
        usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
        loginButton.disableProperty().bind(loginViewModel.isLoginPossibleProperty().not());
    }

    public void Login(ActionEvent actionEvent) throws IOException {
        if (usernameTextField.getText().equals("user") && passwordTextField.getText().equals("pass")) {
            lblStatus.setText("Login success");
        } else {
            lblStatus.setText("Username or password is incorrect.");
        }
    }

    public void goBackToHomeScreen(ActionEvent actionEvent) throws IOException {
        Parent comboBoxViewParent = FXMLLoader.load(getClass().getResource("../main/MainView.fxml"));
        Scene comboBoxViewScene = new Scene(comboBoxViewParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(comboBoxViewScene);
        window.show();
    }

}
