package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.round;

/**
 * Abstract class who representing an Animal
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior {
    private static final String[] ValidColors = {"Red", "Natural", "Blue"};
    private static final int MIN_SIZE = 50;
    private static final int MAX_SIZE = 300;
    private static final int MIN_VER_SPEED = 1;
    private static final int MAX_VER_SPEED = 10;
    private static final int MIN_HOR_SPEED = 1;
    private static final int MAX_HOR_SPEED = 10;
    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private int x_dir = 1;
    private int y_dir = 1;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;

    /**
     * constructor of Animal with 2 parameters
     * @param name - name of the Animal
     * @param p - the point where the Animal
     */
    public Animal(String name, Point p){
        super(p);
        //MessageUtility.logConstractor("Animal", name);
        boolean flag;
        flag = setName(name);
        if(!flag)
            System.out.println("setName failed");
    }

    /**
     * Animal constructor for HW2
     * @param name - name of the animal
     * @param p - point of the animal location
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Animal(String name, Point p, int size, int horSpeed, int verSpeed, String col, double weight, IDiet diet){
        super(p);
        //MessageUtility.logConstractor("Animal", name);
        boolean flag = setName(name);
        setChanges(true);
        eatCount = 0;
        if(!flag)
            System.out.println("setName failed");
        flag = setSize(size);
        if(!flag)
            System.out.println("setSize failed");
        flag = setHorSpeed(horSpeed);
        if(!flag)
            System.out.println("setHorSpeed failed");
        flag = setVerSpeed(verSpeed);
        if(!flag)
            System.out.println("setVerSpeed failed");
        flag = setColor(col);
        if(!flag)
            System.out.println("setColor failed");
        flag = setWeight(weight);
        if(!flag)
            System.out.println("setWeight failed");
        flag = setDiet(diet);
        if(!flag)
            System.out.println("setDiet failed");
    }

    /**
     * name setter
     * @param name - the name you want to set
     * @return true if it succeeds
     */
    public boolean setName(String name) {
        this.name = name;
        boolean flag = this.name.equals(name);
        //MessageUtility.logSetter(name, "setName", name, flag);
        return flag;
    }

    /**
     * returning the name
     * @return name
     */
    public String getName() {
        //MessageUtility.logGetter(name,"getName",name);
        return name;
    }

    /**
     * size setter
     * @param size - the size you want to set
     * @return true if it succeeds
     */
    public boolean setSize(int size) {
        this.size = size;
        boolean flag = this.size == size;
        //MessageUtility.logSetter(name, "setSize", size, flag);
        return flag;
    }

    /**
     * checking if size is legal
     * @param size - size
     * @return true if size is legal
     */
    public static boolean validSize(int size){
        if(size>=MIN_SIZE && size<=MAX_SIZE)
            return true;
        return false;
    }

    /**
     * color setter
     * @param col - the color you want to set
     * @return true if it succeeds
     */
    public boolean setColor(String col) {
        this.col = col;
        boolean flag = this.col.equals(col);
        //MessageUtility.logSetter(name, "setColor", col, flag);
        return flag;
    }

    /**
     * returning the color of the animal
     * @return color
     */
    public String getColor(){
        //MessageUtility.logGetter(name,"getColor", col);
        return this.col;
    }

    /**
     * checking if color is legal
     * @param col - color
     * @return true if color is legal
     */
    public static boolean validColor(String col){
        for(int i=0 ; i<ValidColors.length ; i++)
            if(col.equals(ValidColors[i]))
                return true;
        return false;
    }

    /**
     * vertical speed setter
     * @param verSpeed - the vertical speed you want to set
     * @return true if it succeeds
     */
    public boolean setVerSpeed(int verSpeed) {
        this.verSpeed = verSpeed;
        boolean flag = this.verSpeed == verSpeed;
        //MessageUtility.logSetter(name, "setVerSpeed", verSpeed, flag);
        return flag;
    }

    /**
     * returning the vertical speed of the animal
     * @return vertical speed
     */
    public int getVerSpeed(){
        //MessageUtility.logGetter(name,"getVerSpeed", verSpeed);
        return verSpeed;
    }

    /**
     * checking if vertical speed is legal
     * @param verSpeed - vertical speed
     * @return true if vertical speed is legal
     */
    public static boolean validVerSpeed(int verSpeed){
        if(verSpeed>=MIN_VER_SPEED && verSpeed<=MAX_VER_SPEED)
            return true;
        return false;
    }

    /**
     * horizontal speed setter
     * @param horSpeed - the horizontal speed you want to set
     * @return true if it succeeds
     */
    public boolean setHorSpeed(int horSpeed) {
        this.horSpeed = horSpeed;
        boolean flag = this.horSpeed == horSpeed;
        //MessageUtility.logSetter(name, "setHorSpeed", horSpeed, flag);
        return flag;
    }

    /**
     * returning the horizontal speed of the animal
     * @return horizontal speed
     */
    public int gethorSpeed(){
        //MessageUtility.logGetter(name,"setHorSpeed", horSpeed);
        return horSpeed;
    }

    /**
     * checking if horizontal speed is legal
     * @param horSpeed - horizontal speed
     * @return true if horizontal speed is legal
     */
    public static boolean validHorSpeed(int horSpeed){
        if(horSpeed>=MIN_HOR_SPEED && horSpeed<=MAX_HOR_SPEED)
            return true;
        return false;
    }

    /**
     * returning the weight of the animal
     * @return weight
     */
    public double getWeight(){
        //MessageUtility.logGetter(name,"getWeight", weight);
        return weight;
    }

    /**
     * weight setter
     * @param weight - the weight you want to set
     * @return true if it succeeds
     */
    public boolean setWeight(double weight) {
        if(weight > 0) {
            this.weight = weight;
        }
        boolean flag = this.weight == weight;
        //MessageUtility.logSetter(name, "setWeight", weight, flag);
        return flag;
    }

    /**
     * diet setter
     * @param diet - the diet you want to set
     * @return true if it succeeds
     */
    public boolean setDiet(IDiet diet) {
        this.diet = diet;
        boolean flag =  this.diet == diet;
        //MessageUtility.logSetter(name, "setDiet", "[" + diet.getClass().getSimpleName() + "]", flag);
        return flag;
    }

    /**
     * returning the diet of the animal
     * @return diet
     */
    public IDiet getDiet(){
        return diet;
    }

    /**
     * this method makes "this" eats the food, and update his weight
     * @param food - the food
     * @return true if eat succeed
     */
    public boolean eat(IEdible food) {
        double weight_change = diet.eat(this, food);
        if(weight_change!=0)
            makeSound();
        return weight_change != 0; //return false if weight_change = 0
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.drawObject()
     */
    public void drawObject(Graphics g) {
        if(x_dir==1)
            g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size, size, pan);
        else
            g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size, size, pan);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IDrawable.loadImages()
     */
    public void loadImages(String nm){
        try {img1 = ImageIO.read(new File(PICTURE_PATH + nm + "1.png")); }
        catch (IOException e) {System.out.println("Cannot load image1");}

        try {img2 = ImageIO.read(new File(PICTURE_PATH + nm + "2.png"));}
        catch (IOException e) {System.out.println("Cannot load image2");}
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.getAnimalName()
     */
    public abstract String getAnimalName();

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.getSize()
     */
    public int getSize(){
        //MessageUtility.logGetter(name,"getSize", size);
        return size;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.getEatCount()
     */
    public int getEatCount(){
        //MessageUtility.logGetter(name,"getEatCount", eatCount);
        return eatCount;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.setChanges()
     */
    public void setChanges(boolean state){
        coordChanged = state;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.getChanges()
     */
    public boolean getChanges(){
        return coordChanged;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.eatInc()
     */
    public void eatInc() {
        eatCount++;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see food.IEdible.getFoodType()
     */
    public EFoodType getFoodtype() {
        //MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
        return EFoodType.MEAT;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "]: " + this.name;
    }

    /**
     * making the sound of a specific animal
     */
    public abstract void makeSound();
}
