package animals;

import diet.Herbivore;
import mobility.Point;

public class Turtle extends Animal{
    private static final int STARTING_X = 80;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 1;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 500;
    private static final int DEFAULT_AGE = 1;
    private int age;

    public Turtle(String name, int age){
        super(name, new Point(STARTING_X, STARTING_Y));
        setWeight(STARTING_WEIGHT);
        setDiet(new Herbivore());
        if(validAge(age))
            this.age = age;
        else
            this.age = DEFAULT_AGE;

    }

    private boolean validAge(int age){
        return (age > MIN_AGE && age < MAX_AGE);
    }

    public void setAge(int age) {
        if(validAge(age))
            this.age = age;
    }

    @Override
    public void makeSound() {

    }
}
