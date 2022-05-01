package food;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;

import javax.imageio.ImageIO;


public class Meat implements IEdible, Ilocatable, IDrawable {
    private Point location;
    private BufferedImage img;
    private ZooPanel pan;
    private int size = 70;


    public Meat() {
        loadImages("meat");
    }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        //MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
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
        if(!setLocation(new Point(pan.getWidth()/2, pan.getHeight()/2)))
            System.out.println("Meat location failed");
        g.drawImage(img, location.getX(), location.getY(), size, size, pan);
    }

    public void setPan(ZooPanel pan) {
        this.pan = pan;
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