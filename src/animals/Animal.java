package animals;

import diet.Carnivore;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.IAnimalBehavior;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.RoundingMode;

import static java.lang.Math.round;

/**
 * Abstract class who representing an Animal
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Animal extends Mobile implements IEdible {
    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private Color col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private Thread thread;
    private int x_dir;
    private int y_dir;
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
        MessageUtility.logConstractor("Animal", name);
        boolean flag;
        flag = setName(name);
        if(!flag)
            System.out.println("setName failed");
    }

    /**
     * name setter
     * @param name - the name you want to set
     * @return true if it succeeds
     */
    public boolean setName(String name) {
        this.name = name;
        boolean flag = this.name.equals(name);
        MessageUtility.logSetter(name, "setName", name, flag);
        return flag;
    }

    /**
     * returning the name
     * @return name
     */
    public String getName() {
        MessageUtility.logGetter(name,"getName",name);
        return name;
    }

    /**
     * returning the weight
     * @return weight
     */
    public double getWeight(){
        MessageUtility.logGetter(name,"getWeight", weight);
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
        MessageUtility.logSetter(name, "setWeight", weight, flag);
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
        MessageUtility.logSetter(name, "setDiet", "[" + diet.getClass().getSimpleName() + "]", flag);
        return flag;
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
     * @see food.IEdible.getFoodType()
     */
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
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
