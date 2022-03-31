package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

public class Elephant extends Chewing{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 90;
    private static final double STARTING_WEIGHT = 500;
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double DEFAULT_TRUNK_LENGTH = 1;
    private double trunkLength;

    public Elephant(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        MessageUtility.logConstractor("Elephant", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
        if(!flag)
            System.out.println("Elephant.setTrunkLength - error");
    }

    public Elephant(String name, Point p){
        super(name, p);
        MessageUtility.logConstractor("Elephant", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
        if(!flag)
            System.out.println("Elephant.setTrunkLength - error");
    }

    public Elephant(String name, Point p, double trunkLength){
        super(name, p);
        MessageUtility.logConstractor("Elephant", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        if(validTrunkLength(trunkLength)){
            flag = setTrunkLength(trunkLength);
            if(!flag)
                System.out.println("Elephant.setTrunkLength - error");
        }
        else {
            flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
            if(!flag)
                System.out.println("Elephant.setTrunkLength - error");
        }
    }

    private boolean validTrunkLength(double trunkLength){
        return (trunkLength > MIN_TRUNK_LENGTH && trunkLength < MAX_TRUNK_LENGTH);
    }

    public boolean setTrunkLength(double trunkLength) {
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
        boolean flag = this.trunkLength == trunkLength;
        MessageUtility.logSetter(getName(),"setTrunkLength",trunkLength,flag);
        return flag;
    }

    @Override
    public void chew() {
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");

    }
}
