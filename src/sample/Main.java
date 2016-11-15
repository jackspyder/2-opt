package sample;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();
        ArrayList<Point2D> cities = new ArrayList<>(Load.loadTSPLib("rl5915.tsp"));
        ArrayList<Point2D> nearestN = new ArrayList<Point2D>(5915);
        ArrayList<Point2D> result = new ArrayList<Point2D>(5915);


        double length = Length.routeLength(cities);
        System.out.println("Initial tour length is: " + length);
        double time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken to initialize is: " + time);
        System.out.println("Generating Nearest Neighbour Solution...");
        nearestN = Neighbour.nearest(cities);
        length = Length.routeLength(nearestN);
        System.out.println("Nearest neighbour solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(nearestN);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for init and Nearest Neighbour: " + time);

        startTime = System.currentTimeMillis();
        System.out.println("Attempting 2-opt optimisation...");
        result = TwoOpt.optimise(nearestN);
        length = Length.routeLength(result);
        System.out.println("2-opt solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(result);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for 2 opt optimisation: " + time);


        startTime = System.currentTimeMillis();
        System.out.println("Attempting 2-opt alternate...");
        result = TwoOpt.alternate(result);
        length = Length.routeLength(result);
        System.out.println("2-opt  alternate solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(result);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for 2 opt alternate: " + time);

        System.out.println("Resulting tour node count: " + result.size());


    }


}
