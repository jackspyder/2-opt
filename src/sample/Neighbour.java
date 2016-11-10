package sample;


import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Neighbour {
    public static ArrayList<Point2D> nearest(ArrayList<Point2D> cities){
        ArrayList<Point2D> result = new ArrayList();
        int j;
        Point2D currentCity = cities.remove(0);
        Point2D closestCity = cities.get(0);
        Point2D possible;
        double dist;

        result.add(currentCity);

        while (cities.size() > 0) {

            dist = Double.MAX_VALUE;

            for (j = 0; j < cities.size(); j++) {
                possible = cities.get(j);
                if (currentCity.distance(possible) < dist) {

                    dist = currentCity.distance(possible);
                    closestCity = possible;
                }


            }
            currentCity = closestCity;
            cities.remove(closestCity);
            result.add(currentCity);
        }
        return result;
    }
}





