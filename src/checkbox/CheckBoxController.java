package checkbox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckBoxController implements Initializable {
    @FXML
    private CheckBox peperoniCheckBox;

    @FXML
    private CheckBox saliamiCheckBox;

    @FXML
    private CheckBox hawaiCheckBox;

    @FXML
    private Label pizzaOrderLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaOrderLabel.setText("");
    }

    public void pizzaOrderButtonPushed() {
        String order = "Toppings are:";
        if (peperoniCheckBox.isSelected()) {
            order += "\npeperoni";
        }
        if (saliamiCheckBox.isSelected()) {
            order += "\nsaliami";
        }

        if (hawaiCheckBox.isSelected()) {
            order += "\nhawai";
        }
        this.pizzaOrderLabel.setText(order);
    }
}
