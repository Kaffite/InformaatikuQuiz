package Backend;

import java.util.*;
/*
    Purpose:
    1) Contains the points for each student type
    2) Adds points to the types, based on user's answers
 */
public class Points {
    HashMap<Character, Double> points;

    public Points(HashMap defaultPointMap) {
        points = defaultPointMap;
    }

    public HashMap<Character, Double> getPoints() {
        return points;
    }

    public void addPoints(HashMap pointsToAdd) {
        for (Object o: pointsToAdd.keySet()){
          Double value = (Double) pointsToAdd.get(o);
          points.put((Character) o, points.get(o) + value); // Add value to existing value
        }
    }

    /**
     * Function: Finds the student types (marked with Character) with the most points
     * @return Arraylist of Characters (types) with the most points
     */
    public ArrayList<Character> MostPointsTypes(){
        ArrayList<Character> results = new ArrayList<>();
        double max = 0;
        for (Character c : points.keySet()) {
            double typePoints = points.get(c);
            if( max < typePoints){
                max = typePoints;
                results.clear();
                results.add(c);
            } else if (max == typePoints){
                results.add(c);
            }
        }
        return results;
    }


}
