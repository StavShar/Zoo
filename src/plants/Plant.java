package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
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

    /**
     * Plant constructor, with picture name
     * @param nm picture name
     */
    protected Plant(String nm) {
        loadImages(nm);
        pan = ZooPanel.getInstance();
        Point p = pan.getMidP();
        if(!setLocation(p))
            System.out.println("Plant setLocation failed");
    }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.VEGETABLE;
    }

    /**
     * @return
     */
    public double getHeight() {
        return this.height;
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

    /**
     * @return
     */
    public double getWeight() {
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
