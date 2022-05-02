package food;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import javax.imageio.ImageIO;

/**
 * Representing piece of meat
 *
 * @version 1.0 1 May 2022
 * @author Stav Sharabi
 * */
public class Meat implements IEdible, Ilocatable, IDrawable {
    private Point location;
    private BufferedImage img;
    private ZooPanel pan;
    private int size = 70;

    /**
     * meat constructor with spawn location
     * @param p - Point object, representing spawn location
     */
    public Meat(Point p) {
        loadImages("meat");
        setLocation(p);
    }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#getLocation()
     */
    @Override
    public Point getLocation() {
        return this.location;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#setLocation(mobility.Point)
     */
    @Override
    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.checkBounderies(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.loadImages()
     */
    @Override
    public void loadImages(String nm) {
        try {img = ImageIO.read(new File(PICTURE_PATH + nm + ".gif")); }
        catch (IOException e) {System.out.println("Cannot load image");}

    }

    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.drawObject()
     */
    @Override
    public void drawObject(Graphics g) {
        g.drawImage(img, location.getX(), location.getY(), size, size, pan);
    }

    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.getColor()
     */
    @Override
    public String getColor() {
        return "Natural";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

}