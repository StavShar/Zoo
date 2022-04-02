package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 *Specific class who representing Turtle
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Turtle extends Chewing{
    private static final int STARTING_X = 80;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 1;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 500;
    private static final int DEFAULT_AGE = 1;
    private int age;

    public Turtle(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        MessageUtility.logConstractor("Turtle", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setAge(DEFAULT_AGE);
        if(!flag)
            System.out.println("Turtle.setAge - error");
    }

    public Turtle(String name, Point p){
        super(name, p);
        MessageUtility.logConstractor("Turtle", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setAge(DEFAULT_AGE);
        if(!flag)
            System.out.println("Turtle.setAge - error");
    }

    public Turtle(String name, Point p, int age){
        super(name, p);
        MessageUtility.logConstractor("Turtle", name);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        if(validAge(age)) {
            flag = setAge(age);
            if(!flag)
                System.out.println("Turtle.setAge - error");
        }
        else {
            System.out.println("Illegal age, default age are set.");
            flag = setAge(DEFAULT_AGE);
            if(!flag)
                System.out.println("Turtle.setAge - error");
        }
    }

    public static boolean validAge(int age){
        return (age > MIN_AGE && age < MAX_AGE);
    }

    public boolean setAge(int age) {
        if(validAge(age))
            this.age = age;
        boolean flag = this.age == age;
        MessageUtility.logSetter(getName(),"setAge",age,flag);
        return flag;
    }

    @Override
    public void chew() {
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }
}
