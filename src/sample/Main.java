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

        ArrayList<Point2D> cities = new ArrayList<>(Load.loadTSPLib("rl100.tsp"));
        ArrayList<Point2D> nearestN;
        ArrayList<Point2D> result;

        double length = Length.routeLength(cities);
        System.out.println("Initial tour length is: " + length);

        System.out.println("Generating Nearest Neighbour Solution...");
        nearestN = Neighbour.nearest(cities);
        length = Length.routeLength(nearestN);
        System.out.println("Nearest neighbour solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(nearestN);

        System.out.println("Attempting 2-opt optimisation...");
        result = TwoOpt.optimise(nearestN);
        length = Length.routeLength(result);
        System.out.println("2-opt solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(result);

        System.out.println("Resulting tour node count: " + result.size());


    }


}
