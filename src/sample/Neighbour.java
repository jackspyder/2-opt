package sample;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Neighbour {
    protected static ArrayList<Point2D> nearest(ArrayList<Point2D> cities) {
        ArrayList<Point2D> result = new ArrayList<>(); //resulting nearest neighbour arraylist.
        Point2D currentCity;
        Point2D closestCity;
        double shortest = Double.MAX_VALUE;
        currentCity = cities.remove(0);
        closestCity = cities.get(0);
        System.out.println("Start City: " + currentCity + " closest " + closestCity);

        for (Point2D outer : cities) {
            System.out.println("Outer City: " + outer); // must clone arrays, removal of an item during inner causes outer to break!!!
            result.add(currentCity);
            for (Point2D inner : cities) {
                System.out.println("inner " + inner);
                if (currentCity.distance(inner) < shortest) {
                    closestCity = inner;
                    shortest = currentCity.distance(inner);
                    System.out.println("current " + currentCity + " plus inner " + inner + " is " + shortest);
                }
            }
            cities.remove(closestCity);
            currentCity = closestCity;
            closestCity = cities.get(0);
            shortest = Double.MAX_VALUE;
            System.out.println("Shortest is: " + shortest);
            System.out.println("The current City is now: " + currentCity);

        }
        System.out.println("Optimised route is: " + result);
        return result;
    }
}
