package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 *Specific class who representing Elephant
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Elephant extends Chewing{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 90;
    private static final double STARTING_WEIGHT = 500;
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double DEFAULT_TRUNK_LENGTH = 1;
    private double trunkLength;

    /**
     * constructor of Elephant with name only
     * @param name - name of the Elephant
     */
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

    /**
     * constructor of Elephant with 2 parameters
     * @param name - name of the Elephant
     * @param p - the point where the Elephant
     */
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

    /**
     * constructor of Elephant with 3 parameters
     * @param name - name of the Elephant
     * @param p - the point where the Elephant
     * @param trunkLength - the trunk length of the Elephant
     */
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

    /**
     * checking validation of the trunk length
     * @param trunkLength - the trunk length we are checking
     * @return true if the trunk length is legal
     */
    public static boolean validTrunkLength(double trunkLength){
        return (trunkLength > MIN_TRUNK_LENGTH && trunkLength < MAX_TRUNK_LENGTH);
    }

    /**
     * trunk length setter
     * @param trunkLength - the trunk length you want to set
     * @return true if it succeeds
     */
    public boolean setTrunkLength(double trunkLength) {
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
        boolean flag = this.trunkLength == trunkLength;
        MessageUtility.logSetter(getName(),"setTrunkLength",trunkLength,flag);
        return flag;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Chewing.chew()
     */
    public void chew() {
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");

    }
}
