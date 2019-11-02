package table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import person.PersonViewController;
import person.PersonModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class TableViewController {
    @FXML
    private TableView<PersonModel> tableView;

    @FXML
    private TableColumn<PersonModel, String> firstNameColumn;

    @FXML
    private TableColumn<PersonModel, String> lastNameColumn;

    @FXML
    private TableColumn<PersonModel, LocalDate> birthdayColumn;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    void initialize() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<PersonModel, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<PersonModel, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<PersonModel, LocalDate>("birthday"));

        tableView.setItems(getPeople());

        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private ObservableList<PersonModel> getPeople() {
        ObservableList<PersonModel> people = FXCollections.observableArrayList();
        people.add(new PersonModel("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new PersonModel("Rebecca", "Fergusson", LocalDate.of(1986, Month.JULY, 21)));
        people.add(new PersonModel("Mr.", "T", LocalDate.of(1952, Month.MAY, 21)));

        return people;
    }

    public void changeFirstNameCellEvent(TableColumn.CellEditEvent edditedCell) {
        PersonModel personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(edditedCell.getNewValue().toString());
    }

    public void changeLastNameCellEvent(TableColumn.CellEditEvent edditedCell) {
        PersonModel personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(edditedCell.getNewValue().toString());
    }

    public void newPersonButtonPushed() {
        PersonModel newPerson = new PersonModel(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                birthdayDatePicker.getValue());

        tableView.getItems().add(newPerson);
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        birthdayDatePicker.setValue(null);
    }

    public void handleDeletePersonButtonAction() {
        ObservableList<PersonModel> selectedRows, allPeople;
        allPeople = tableView.getItems();

        // this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (PersonModel person : selectedRows) {
            allPeople.remove(person);
        }
    }

    public void changeSceneToDetailedPersonView(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../person/PersonView.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        PersonViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
