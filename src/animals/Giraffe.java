package animals;

import diet.Herbivore;
import mobility.Point;

public class Giraffe extends Animal{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 450;
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;
    private double neckLength;

    public Giraffe(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
            this.neckLength = DEFAULT_NECK_LENGTH;
    }

    public Giraffe(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        this.neckLength = DEFAULT_NECK_LENGTH;
    }

    public Giraffe(String name, Point p, double neckLength){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
        else {
            System.out.println("Illegal neck length, default neck length are set.");
            this.neckLength = DEFAULT_NECK_LENGTH;
        }
    }

    /*mine*/private boolean validNeckLength(double neckLength){
        return (neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH);
    }

    /*mine*/public boolean setNeckLength(double neckLength) {
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
        return this.neckLength == neckLength;
    }

    @Override
    public void makeSound() {

    }
}
