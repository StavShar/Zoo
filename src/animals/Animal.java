package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Abstract class who representing an Animal
 *
 * @version 3.0 18 May 2022
 * @author Stav Sharabi
 * */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable {
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
    public Thread thread;
    protected boolean threadSuspended;
    private ZooPanel pan;
    private boolean alive;
    private BufferedImage img1, img2;

    /**
     * constructor of Animal with 2 parameters
     * @param name - name of the Animal
     * @param p - the point where the Animal
     */
    public Animal(String name, Point p){
        super(p);
        boolean flag;
        alive = true;
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
        boolean flag = setName(name);
        setChanges(true);
        alive = true;
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
        pan = ZooPanel.getInstance();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        Point p;
        int newX, newY;
        while (alive) {
            try {
                synchronized (this) {
                    if(this.threadSuspended == true)
                        wait();
                }
                p = getLocation();
                newX = p.getX() + horSpeed * x_dir;
                newY = p.getY() + verSpeed * y_dir;
                if (Point.checkBounderies(new Point(newX, newY)))
                    move(new Point(newX, newY));
                else {
                    if (Point.getXMax() < newX) {//turn left
                        newX = Point.getXMax();
                        x_dir = -1;
                    } else if (Point.getXMin() > newX) {//turn right
                        newX = Point.getXMin();
                        x_dir = 1;
                    }
                    if (Point.getYMax() < newY) {//turn down
                        newY = Point.getYMax();
                        y_dir = -1;
                    } else if (Point.getYMin() > newY) {//turn up
                        newY = Point.getYMin();
                        y_dir = 1;
                    }
                    move(new Point(newX, newY));
                }
                setChanges(true);
                Thread.sleep(50);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this thread will end his job
     */
    public void kill(){
        alive = false;
    }

    /**
     * set new direction on X axis
     * @param x_dir x direction
     */
    public void setX_dir(int x_dir) {
        this.x_dir = x_dir;
    }

    /**
     * set new direction on Y axis
     * @param y_dir y direction
     */
    public void setY_dir(int y_dir) {
        this.y_dir = y_dir;
    }

    /**
     * name setter
     * @param name - the name you want to set
     * @return true if it succeeds
     */
    public boolean setName(String name) {
        this.name = name;
        boolean flag = this.name.equals(name);
        return flag;
    }

    /**
     * returning the name
     * @return name
     */
    public String getName() {
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
        return flag;
    }

    /**
     * returning the color of the animal
     * @return color
     */
    public String getColor(){
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
        return flag;
    }

    /**
     * returning the vertical speed of the animal
     * @return vertical speed
     */
    public int getVerSpeed(){
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
     * returning the maximum distance for eating
     * @return EAT_DISTANCE
     */
    public int getEAT_DISTANCE() {
        return EAT_DISTANCE;
    }

    /**
     * horizontal speed setter
     * @param horSpeed - the horizontal speed you want to set
     * @return true if it succeeds
     */
    public boolean setHorSpeed(int horSpeed) {
        this.horSpeed = horSpeed;
        boolean flag = this.horSpeed == horSpeed;
        return flag;
    }

    /**
     * returning the horizontal speed of the animal
     * @return horizontal speed
     */
    public int gethorSpeed(){
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
     * @see mobility.Mobile.move()
     */
    public double move(Point p) {
        double distance = super.move(p);
        if(Point.checkBounderies(p))
            setWeight(getWeight() - (distance * getWeight() * 0.00025));
        return distance;
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
     * @see graphics.IAnimalBehavior.setSuspended()
     */
    public synchronized void setSuspended(){
        threadSuspended =  true;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see graphics.IAnimalBehavior.setResumed()
     */
    public synchronized void setResumed(){
        threadSuspended =  false;
        notify();
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see food.IEdible.getFoodType()
     */
    public EFoodType getFoodtype() {
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
