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

    public void setName(String name) {
        this.name = name;
    }

    public IDiet getDiet() {
        return diet;
    }

    public void setDiet(IDiet diet) {
        this.diet = diet;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public boolean eat(IEdible food){
        double w = getWeight();
        w -= diet.eat(this,food);
        return (!(w == 0));
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    public abstract void makeSound();
}
