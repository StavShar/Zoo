package animals;

import diet.Carnivore;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

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

    public Animal(String name, Point p){
        super(p);
        MessageUtility.logConstractor("Animal", name);
        boolean flag;
        flag = setName(name);
        if(!flag)
            System.out.println("setName failed");
    }


    public boolean setName(String name) {
        this.name = name;
        boolean flag = this.name.equals(name);
        MessageUtility.logSetter(name, "setName", name, flag);
        return flag;
    }

    public String getName() {
        MessageUtility.logGetter(name,"getName",name);
        return name;
    }

    public double getWeight(){
        MessageUtility.logGetter(name,"getWeight", weight);
        return weight;
    }

    public boolean setWeight(double weight) {
        if(weight > 0) {
            this.weight = weight;
        }
        boolean flag = this.weight == weight;
        MessageUtility.logSetter(name, "setWeight", weight, flag);
        return flag;
    }

    public boolean setDiet(IDiet diet) {
        this.diet = diet;
        boolean flag =  this.diet == diet;
        MessageUtility.logSetter(name, "setDiet", "[" + diet.getClass().getSimpleName() + "]", flag);
        return flag;
    }


    public boolean eat(IEdible food) {
        double weight_change = diet.eat(this, food);
        if(weight_change!=0)
            makeSound();
        return weight_change != 0; //return false if weight_change = 0
    }

    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
        return EFoodType.MEAT;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "]: " + this.name;
    }

    public abstract void makeSound();
}
