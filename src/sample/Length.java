package sample;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Length {
    public static double routeLength(ArrayList<Point2D> cities) {

        //Calculate the length of a TSP route held in an ArrayList as a set of Points
        double result = 0; //Holds the route length
        Point2D prev = cities.get(cities.size() - 1);

        //Set the previous city to the last city in the ArrayList as we need to measure the length of the entire loop
        for (Point2D city : cities) {

            //Go through each city in turn
            result += city.distance(prev);

            //get distance from the previous city
            prev = city;

            //current city will be the previous city next time
        }
        return result;
    }
}
