package combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxController {
    @FXML
    private Label comboBoxLabel;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox comboBox2;

    ObservableList<String> list = FXCollections.observableArrayList("Jonas", "Tomas", "Petras");

    @FXML
    void initialize() {
        comboBox1.setItems(list);

        comboBox2.getItems().add("Jonaitis");
        comboBox2.getItems().addAll("Tomaitis", "Petraitis");
    }

    public void comboBoxWasUpdated() {
        this.comboBoxLabel.setText("Option selected: \n" + comboBox1.getValue().toString());
    }

}
