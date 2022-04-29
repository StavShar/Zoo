package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;

/**
 * @author baroh
 *
 */
public abstract class Plant implements IEdible, Ilocatable, IDrawable {
    /**
     *
     */
    private double height;
    /**
     *
     */
    private Point location;
    /**
     *
     */
    private double weight;
    /**
     *
     */
    private BufferedImage img;
    private ZooPanel pan;
    private int size = 70;

    public Plant(String nm) {
        Random rand = new Random();
        loadImages(nm);
        int x = rand.nextInt(30);
        int y = rand.nextInt(12);
        this.location = new Point(x, y);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        //MessageUtility.logConstractor("Plant", "Plant");
    }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        //MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
        return EFoodType.VEGETABLE;
    }

    /**
     * @return
     */
    public double getHeight() {
        //MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#getLocation()
     */
    @Override
    public Point getLocation() {
        //MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }

    /**
     * @return
     */
    public double getWeight() {
        //MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }

    /**
     * @param height
     * @return
     */
    public boolean setHeight(double height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        //MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
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
        //MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }

    /**
     * @param weight
     * @return
     */
    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        //MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.loadImages()
     */
    @Override
    public void loadImages(String nm) {
        try {img = ImageIO.read(new File(PICTURE_PATH + nm + ".png")); }
        catch (IOException e) {System.out.println("Cannot load image");}

    }

    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.drawObject()
     */
    @Override
    public void drawObject(Graphics g) {
        g.drawImage(img, pan.getWidth()/2, pan.getHeight()/2, size, size, pan);
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
