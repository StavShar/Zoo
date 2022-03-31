package animals;

import diet.Carnivore;
import diet.Omnivore;
import mobility.Point;

public class Bear extends Animal{
    private static final int STARTING_X = 100;
    private static final int STARTING_Y = 5;
    private static final double STARTING_WEIGHT = 308.2;
    private static final String DEFAULT_FUR_COLOR = "GRAY";
    private String furColor;

    public Bear(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        furColor = DEFAULT_FUR_COLOR;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    public Bear(String name, Point p){
        super(name, p);
        boolean flag;
        furColor = DEFAULT_FUR_COLOR;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    public Bear(String name, Point p, String furColor){
        super(name, p);
        boolean flag;
        if(validFurColor(furColor))
            this.furColor = furColor;
        else {
            System.out.println("Illegal fur color, default fur color are set.");
            this.furColor = DEFAULT_FUR_COLOR;
        }
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    /*mine*/public boolean setFurColor(String furColor) {
        if(validFurColor(furColor))
            this.furColor = furColor;
        return this.furColor.equals(furColor);
    }
    /*mine*/public static boolean validFurColor(String furColor){
        return (furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY"));
    }

    @Override
    public void makeSound() {

    }
}
