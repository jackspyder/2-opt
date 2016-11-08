package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {




    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
       // launch(args);

        ArrayList<Point2D> cities = new ArrayList<>(Load.loadTSPLib("rl10.tsp"));
        ArrayList<Point2D> result =  new ArrayList<>();





        System.out.println(cities);

    }

}
