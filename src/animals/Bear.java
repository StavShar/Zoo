package animals;

import diet.Omnivore;
import mobility.Point;

public class Bear extends Animal{
    private static final int STARTING_X = 100;
    private static final int STARTING_Y = 5;
    private static final double STARTING_WEIGHT = 308.2;
    private static final String DEFAULT_FUR_COLOR = "GRAY";
    private String furColor;

    public Bear(String name, String furColor){
        super(name, new Point(STARTING_X, STARTING_Y));
        setWeight(STARTING_WEIGHT);
        setDiet(new Omnivore());
        this.furColor = DEFAULT_FUR_COLOR;
        setFurColor(furColor);
    }

    public void setFurColor(String furColor) {
        if(validFurColor(furColor))
            this.furColor = furColor;
    }
    private boolean validFurColor(String furColor){
        return (furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY"));
    }

    @Override
    public void makeSound() {

    }
}
