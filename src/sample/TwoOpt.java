package sample;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TwoOpt {
    public static ArrayList<Point2D> optimise(ArrayList<Point2D> cities) {
        ArrayList<Point2D> newTour;
        double bestDist = Length.routeLength(cities);
        double newDist;
        int improve = 0;
        int comparisons = 0;

        for (int i = 1; i < cities.size() - 2; i++) {
            for (int j = i + 1; j < cities.size() - 1; j++) {

                newTour = swap(cities, i, j);
                comparisons++;
                newDist = Length.routeLength(newTour);
                if (newDist < bestDist) {
                    cities = newTour;
                    bestDist = newDist;
                    improve++;
                    System.out.println("Comparisons made: " + comparisons);
                    System.out.println("Improvements made: " + improve);

                }
            }
        }

        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total improvements made: " + improve);
        return cities;
    }

    public static ArrayList<Point2D> alternate(ArrayList<Point2D> cities) {

        ArrayList<Point2D> newTour;
        double bestDist = Length.routeLength(cities);
        double newDist;
        int swaps = 1;
        int improve = 0;
        int comparisons = 0;

        while (swaps != 0) {
            swaps = 0;
            for (int i = 1; i < cities.size() - 2; i++) {
                for (int j = i + 1; j < cities.size() - 1; j++) {
                    if ((cities.get(i).distance(cities.get(i - 1)) + cities.get(j + 1).distance(cities.get(j))) >=
                            (cities.get(i).distance(cities.get(j + 1)) + cities.get(i - 1).distance(cities.get(j)))) {

                        newTour = swap(cities, i, j);

                        newDist = Length.routeLength(newTour);
                        comparisons++;
                        if (newDist < bestDist) {
                            cities = newTour;
                            bestDist = newDist;
                            swaps++;
                            improve++;
                        }

                    }
                }
            }
        }
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total improvements made: " + improve);
        return cities;
    }

    private static ArrayList<Point2D> swap(ArrayList<Point2D> cities, int i, int j) {

        ArrayList<Point2D> newTour = new ArrayList<>();

        int size = cities.size();
        //
        for (int c = 0; c <= i - 1; c++) {
            newTour.add(cities.get(c));
        }

        int dec = 0;
        for (int c = i; c <= j; c++) {
            newTour.add(cities.get(j - dec));
            dec++;
        }

        for (int c = j + 1; c < size; c++) {
            newTour.add(cities.get(c));
        }

        return newTour;

    }
}
