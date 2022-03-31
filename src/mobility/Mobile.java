package mobility;

import utilities.MessageUtility;

import java.lang.Math;
import static mobility.Point.checkBounderies;

public abstract class Mobile implements Ilocatable{
    private Point location;
    private double totalDistance; //>0

    public Mobile(Point p){
        setLocation(p);
        totalDistance = 0;
    }

    public void addTotalDistance(double td){
        totalDistance += td;
    }

    public double calcDistance(Point p){
        return Math.sqrt(Math.pow(p.getX()-location.getX(), 2) + Math.pow(p.getY()-location.getY(), 2));
    }

    public double move(Point p){
        double distance;
        if(!checkBounderies(p))//point out of range
            return 0;
        distance = calcDistance(p);
        addTotalDistance(distance);
        setLocation(p);

        return distance;
    }

    public Point getLocation() {
        return location;
    }

    public boolean setLocation(Point p){
        if(checkBounderies(p))
            location = p;
        return checkBounderies(p);

    }
}
