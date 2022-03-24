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

    public Giraffe(String name, double neckLength){
        super(name, new Point(STARTING_X, STARTING_Y));
        setWeight(STARTING_WEIGHT);
        setDiet(new Herbivore());
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
        else
            this.neckLength = DEFAULT_NECK_LENGTH;

    }

    private boolean validNeckLength(double neckLength){
        return (neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH);
    }

    public void setNeckLength(double neckLength) {
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
    }

    @Override
    public void makeSound() {

    }
}
