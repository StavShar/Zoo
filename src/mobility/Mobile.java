package mobility;

import java.lang.Math;
import static mobility.Point.cheackBounderies;

public abstract class Mobile implements Ilocatable{
    private Point location;
    private double totalDistance; //>0

    public Mobile(Point p){
        location = p;
        totalDistance = 0;
    }

    public void addTotalDistance(double td){
        totalDistance += td;
    }

    public double calcDistance(Point p){
        return Math.sqrt(Math.pow(p.getX()-location.getX(), 2) + Math.pow(p.getY()-location.getY(), 2));
    }

    public double move(Point p){
        double distance = calcDistance(p);
        if(distance != 0){
            location = p;
            addTotalDistance(distance);
        }
        return distance;
    }

    public Point getLocation() {
        return location;
    }

    public boolean setLocation(Point p){
        if(cheackBounderies(p))
            location = p;
        return cheackBounderies(p);

    }
}
