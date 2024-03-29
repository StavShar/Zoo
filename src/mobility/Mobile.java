package mobility;

import java.lang.Math;
import java.util.Observable;

import static mobility.Point.checkBounderies;

/**
 * Abstract class, representing movement in my zoo
 *
 * @version 2.0 6 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Mobile extends Observable implements Ilocatable, Cloneable{
    private Point location;
    private double totalDistance; //>0

    /**
     * constructor for Mobile class, initialize totalDistance to be zero and setting p as the location
     * @param p - the new location
     */
    public Mobile(Point p){
        setLocation(p);
        totalDistance = 0;
    }

    /**
     * update the total distance
     * @param td - distance you want to add
     */
    public void addTotalDistance(double td){
        totalDistance += td;
    }

    /**
     * calculating the distance between 2 points(this and p) by Pythagoras method's
     * @param p - point
     * @return the distance
     */
    public double calcDistance(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.getLocation().getX(), 2) + Math.pow(p.getY()-this.getLocation().getY(), 2));
    }

    /**
     * moving to new point and return the distance
     * @param p - new point
     * @return the traveled distance
     */
    public double move(Point p){
        double distance;
        if(!checkBounderies(p))//point out of range
            return 0;
        distance = this.calcDistance(p);
        addTotalDistance(distance);
        setLocation(p);
        return distance;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object.Clone()
     */
    protected Object clone()   {
        Mobile clone = null;
        try
        {
            clone =(Mobile) super.clone();
            clone.totalDistance = 0;
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
   /*
    * (non-Javadoc)
    *
    * @see mobility.Ilocatable.getLocation()
    */
    public Point getLocation() {
        return location;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see mobility.Ilocatable.setLocation()
     */
    public boolean setLocation(Point p){
            location = new Point(p.getX(), p.getY());
        return location.equals(p);
    }
}
