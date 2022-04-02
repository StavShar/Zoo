package mobility;

import utilities.MessageUtility;

import java.lang.Math;
import static mobility.Point.checkBounderies;

/**
 * Abstract class, representing movement in my zoo
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
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
        return Math.sqrt(Math.pow(p.getX()-this.getLocation().getX(), 2) + Math.pow(p.getY()-this.getLocation().getY(), 2));
    }

    public double move(Point p){
        double distance;
        if(!checkBounderies(p))//point out of range
            return 0;
        distance = this.calcDistance(p);
        addTotalDistance(distance);
        setLocation(p);
        return distance;
    }

    public Point getLocation() {
        return location;
    }

    public boolean setLocation(Point p){
            location = new Point(p.getX(), p.getY());
        return location.equals(p);
    }
}
