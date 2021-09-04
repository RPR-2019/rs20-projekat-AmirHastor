package ba.unsa.etf.rs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Hospital extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Hospital.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root, 800, 330));
        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
