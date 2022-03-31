package animals;

import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Random;

public class Lion extends Roaring{
    private static final int STARTING_X = 20;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 408.2;
    private static final int SCAR_CHANCE = 50; // percentage
    private int scarCount;

    public Lion(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        MessageUtility.logConstractor("Lion", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Lion.setWeight - error");
        flag = setDiet(new Carnivore());
        if(!flag)
            System.out.println("Lion.setDiet - error");
        scarCount = 0;
    }

    public Lion(String name, Point p){
        super(name, p);
        MessageUtility.logConstractor("Lion", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Lion.setWeight - error");
        flag = setDiet(new Carnivore());
        if(!flag)
            System.out.println("Lion.setDiet - error");
        scarCount = 0;
    }

    @Override
    public boolean eat(IEdible food) {
        if(super.eat(food)){
            Random rand = new Random();
            if(rand.nextInt(1,100) <= SCAR_CHANCE)
                scarCount++;
            return true;
        }
        //else
        return false;
    }

    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(getName(),"getFoodtype",EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }

    @Override
    public void roar() {
        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }
}
