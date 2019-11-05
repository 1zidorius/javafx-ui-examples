package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
//        MenuBar menuBar = new MenuBar();
//        Menu menu = new Menu("File");
//        MenuItem quit = new MenuItem("Quit");
//        quit.setOnAction(e -> Platform.exit());
//        menu.getItems().add(quit);
//        menuBar.getMenus().add(menu);
//        menuBar.setUseSystemMenuBar(true);
//
//        BorderPane root = new BorderPane();
//        root.setTop(menuBar);
//        Scene scene = new Scene(root, 600, 600);
//        primaryStage.setScene(scene);
//        primaryStage.show();


        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
