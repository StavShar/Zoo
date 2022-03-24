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

    public Elephant(String name, double trunkLength){
        super(name, new Point(STARTING_X, STARTING_Y));
        setWeight(STARTING_WEIGHT);
        setDiet(new Herbivore());
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
        else
            this.trunkLength = DEFAULT_TRUNK_LENGTH;

    }

    private boolean validTrunkLength(double trunkLength){
        return (trunkLength > MIN_TRUNK_LENGTH && trunkLength < MAX_TRUNK_LENGTH);
    }

    public void settrunkLength(double trunkLength) {
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {

    }
}
