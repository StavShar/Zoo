package animals;

import diet.Carnivore;
import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 *Specific class who representing bear
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Bear extends Roaring{
    private static final int STARTING_X = 100;
    private static final int STARTING_Y = 5;
    private static final double STARTING_WEIGHT = 308.2;
    private static final String DEFAULT_FUR_COLOR = "GRAY";
    private String furColor;

    public Bear(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        MessageUtility.logConstractor("Bear", name);
        boolean flag;
        flag = setFurColor(DEFAULT_FUR_COLOR);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    public Bear(String name, Point p){
        super(name, p);
        MessageUtility.logConstractor("Bear", name);
        boolean flag;
        flag = setFurColor(DEFAULT_FUR_COLOR);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    public Bear(String name, Point p, String furColor){
        super(name, p);
        MessageUtility.logConstractor("Bear", name);
        boolean flag;
        if(validFurColor(furColor)){
            flag = setFurColor(furColor);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        }
        else {
            System.out.println("Illegal fur color, default fur color are set.");
            flag = setFurColor(DEFAULT_FUR_COLOR);
            if(!flag)
                System.out.println("Bear.setFurColor - error");
        }
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    public boolean setFurColor(String furColor) {
        if(validFurColor(furColor))
            this.furColor = furColor;
        boolean flag = this.furColor.equals(furColor);
        MessageUtility.logSetter(getName(),"setFurColor",furColor,flag);
        return flag;
    }

    public static boolean validFurColor(String furColor){
        return (furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY"));
    }

    @Override
    public void roar() {
        MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }
}
