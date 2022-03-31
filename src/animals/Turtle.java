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

    public Turtle(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
            this.age = DEFAULT_AGE;
    }

    public Turtle(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        this.age = DEFAULT_AGE;
    }

    public Turtle(String name, Point p, int age){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        if(validAge(age))
            this.age = age;
        else {
            System.out.println("Illegal age, default age are set.");
            this.age = DEFAULT_AGE;
        }
    }

    /*mine*/private boolean validAge(int age){
        return (age > MIN_AGE && age < MAX_AGE);
    }

    /*mine*/public boolean setAge(int age) {
        if(validAge(age))
            this.age = age;
        return this.age == age;
    }

    @Override
    public void makeSound() {

    }
}
