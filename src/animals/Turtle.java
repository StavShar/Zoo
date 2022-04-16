package animals;

import diet.Herbivore;
import diet.IDiet;
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

    /**
     * constructor of turtle with name only
     * @param name - name of the turtle
     */
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

    /**
     * constructor of turtle with 2 parameters
     * @param name - name of the turtle
     * @param p - the point where the turtle
     */
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

    /**
     * constructor of turtle with 3 parameters
     * @param name - name of the turtle
     * @param p - the point where the turtle
     * @param age - the age of the turtle
     */
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

    /**
     * turtle constructor for hw2
     * @param name - name of the animal
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Turtle(String name, int size, int horSpeed, int verSpeed, String col){
        super(name, new Point(STARTING_X, STARTING_Y), size, horSpeed, verSpeed, col, size*0.5, new Herbivore());
        MessageUtility.logConstractor("Turtle", name);
        boolean flag = setAge(DEFAULT_AGE);
        if(!flag)
            System.out.println("Turtle.setAge - error");
        if(col.equals("Natural"))
            loadImages("trt_n_");
        else if(col.equals("Red"))
            loadImages("trt_r_");
        else if(col.equals("Blue"))
            loadImages("trt_b_");
    }

    /**
     * checking validation of an age
     * @param age - the age we are checking
     * @return true if the age is legal
     */
    public static boolean validAge(int age){
        return (age > MIN_AGE && age < MAX_AGE);
    }

    /**
     * age setter
     * @param age - the age you want to set
     * @return true if it succeeds
     */
    public boolean setAge(int age) {
        if(validAge(age))
            this.age = age;
        boolean flag = this.age == age;
        MessageUtility.logSetter(getName(),"setAge",age,flag);
        return flag;
    }

    /*
     * (non-Javadoc)
     *
     * @see animals.getAnimalName()
     */
    @Override
    public String getAnimalName(){
        return "Turtle";
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Chewing.chew()
     */
    public void chew() {
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }
}
