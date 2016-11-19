package sample;

        import java.awt.geom.Point2D;
        import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();
        ArrayList<Point2D> cities = new ArrayList<>(Load.loadTSPLib("rl11849.tsp")); //alter file name here.
        ArrayList<Point2D> nearestN;
        ArrayList<Point2D> result;

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
        result = TwoOpt.alternate(nearestN);
        length = Length.routeLength(result);
        System.out.println("2-opt solution complete, distance: " + length);
        System.out.println("Validating solution...");
        Validator.validate(result);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for 2 opt optimisation: " + time);

        System.out.println("Resulting tour node count: " + result.size());

    }
}
