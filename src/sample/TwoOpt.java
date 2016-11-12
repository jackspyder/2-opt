package sample;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TwoOpt {
    public static ArrayList<Point2D> optimise(ArrayList<Point2D> cities) {
        ArrayList<Point2D> newTour;
        double bestDist = Length.routeLength(cities);
        double newDist;
        int swaps = 0;

        for (int i = 0; i < cities.size() - 1; i++) {
            for (int j = i + 1; j < cities.size(); j++) {

                newTour = swap(cities, i, j);
                newDist = Length.routeLength(newTour);
                if (newDist < bestDist) {
                    cities = newTour;
                    bestDist = newDist;
                    swaps++;
                }
            }
        }

        System.out.println("Swaps: " + swaps);
        return cities;
    }

    private static ArrayList<Point2D> swap(ArrayList<Point2D> cities, int i, int j) {

        ArrayList<Point2D> newTour = new ArrayList<>();

        int size = cities.size();
        //
        for(int c = 0; c <= i-1; c++){
            newTour.add(cities.get(c));
        }

        int dec = 0;
        for(int c = i; c<=j; c++){
            newTour.add(cities.get(j-dec));
            dec++;
        }

        for(int c = j+1; c < size; c++){
            newTour.add(cities.get(c));
        }

        return newTour;

    }
}
