package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 *Specific class who representing Giraffe
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Giraffe extends Chewing{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 450;
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;
    private double neckLength;

    public Giraffe(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        MessageUtility.logConstractor("Giraffe", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setNeckLength(DEFAULT_NECK_LENGTH);
        if(!flag)
            System.out.println("Giraffe.setNeckLength - error");
    }

    public Giraffe(String name, Point p){
        super(name, p);
        MessageUtility.logConstractor("Giraffe", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setNeckLength(DEFAULT_NECK_LENGTH);
        if(!flag)
            System.out.println("Giraffe.setNeckLength - error");
    }

    public Giraffe(String name, Point p, double neckLength){
        super(name, p);
        MessageUtility.logConstractor("Giraffe", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        if(validNeckLength(neckLength)) {
            flag = setNeckLength(neckLength);
            if(!flag)
                System.out.println("Giraffe.setNeckLength - error");
        }
        else {
            System.out.println("Illegal neck length, default neck length are set.");
            flag = setNeckLength(DEFAULT_NECK_LENGTH);
            if(!flag)
                System.out.println("Giraffe.setNeckLength - error");
        }
    }

    public static boolean validNeckLength(double neckLength){
        return (neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH);
    }

    public boolean setNeckLength(double neckLength) {
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
        boolean flag = this.neckLength == neckLength;
        MessageUtility.logSetter(getName(),"setNeckLength",neckLength,flag);
        return flag;
    }

    @Override
    public void chew() {
        MessageUtility.logSound(getName(),"Bleats and Stomps its legs, then chews");
    }
}
