package login;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginView {
    @FXML
    public Label lblStatus;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
        LoginViewModel loginViewModel = new LoginViewModel();
        usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
        loginButton.disableProperty().bind(loginViewModel.isLoginPossibleProperty().not());
    }

    public void Login(javafx.event.ActionEvent actionEvent) throws IOException {
        if (usernameTextField.getText().equals("user") && passwordTextField.getText().equals("pass")) {
            lblStatus.setText("Login success");
        } else {
            lblStatus.setText("Username or password is incorrect.");
        }
    }

}
