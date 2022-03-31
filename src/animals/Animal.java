package animals;

import diet.Carnivore;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;

public abstract class Animal extends Mobile implements IEdible {
    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name, Point p){
        super(p);
        this.name = name;
    }

    /*mine*/public double getWeight(){
        return weight;
    }

    /*mine*/public boolean setWeight(double weight) {
        this.weight = weight;
        return this.weight == weight;
    }

    /*mine*/public IDiet getDiet() {
        return diet;
    }

    /*mine*/public boolean setDiet(IDiet diet) {
        this.diet = diet;
        return this.diet == diet;
    }


    public boolean eat(IEdible food) {
        double weight_change = diet.eat(this, food);
        return weight_change != 0; //return false if weight_change = 0
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    public abstract void makeSound();
}
