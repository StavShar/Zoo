package animals;

import diet.Herbivore;
import mobility.Point;

public class Elephant extends Animal{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 90;
    private static final double STARTING_WEIGHT = 500;
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double DEFAULT_TRUNK_LENGTH = 1;
    private double trunkLength;

    public Elephant(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        this.trunkLength = DEFAULT_TRUNK_LENGTH;
    }

    public Elephant(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        this.trunkLength = DEFAULT_TRUNK_LENGTH;
    }

    /*mine*/private boolean validTrunkLength(double trunkLength){
        return (trunkLength > MIN_TRUNK_LENGTH && trunkLength < MAX_TRUNK_LENGTH);
    }

    /*mine*/public boolean settrunkLength(double trunkLength) {
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
        return this.trunkLength == trunkLength;
    }

    @Override
    public void makeSound() {

    }
}
