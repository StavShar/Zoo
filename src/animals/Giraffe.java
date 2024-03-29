package animals;

import diet.Herbivore;
import mobility.Point;

/**
 *Specific class who representing Giraffe
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Giraffe extends Chewing{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 450;
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;
    private double neckLength;

    /**
     * constructor of Giraffe with name only
     * @param name - name of the Giraffe
     */
    public Giraffe(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setNeckLength(DEFAULT_NECK_LENGTH);
        if(!flag)
            System.out.println("Giraffe.setNeckLength - error");
    }

    /**
     * constructor of Giraffe with 2 parameters
     * @param name - name of the Giraffe
     * @param p - the point where the Giraffe
     */
    public Giraffe(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        flag = setNeckLength(DEFAULT_NECK_LENGTH);
        if(!flag)
            System.out.println("Giraffe.setNeckLength - error");
    }

    /**
     * constructor of Giraffe with 3 parameters
     * @param name - name of the Giraffe
     * @param p - the point where the Giraffe
     * @param neckLength - the neck length of the Giraffe
     */
    public Giraffe(String name, Point p, double neckLength){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Giraffe.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Giraffe.setDiet - error");
        if(validNeckLength(neckLength)) {
            flag = setNeckLength(neckLength);
            if(!flag)
                System.out.println("Giraffe.setNeckLength - error");
        }
        else {
            System.out.println("Illegal neck length, default neck length are set.");
            flag = setNeckLength(DEFAULT_NECK_LENGTH);
            if(!flag)
                System.out.println("Giraffe.setNeckLength - error");
        }
    }

    /**
     * giraffe constructor for hw2
     * @param name - name of the animal
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Giraffe(String name, int size, int horSpeed, int verSpeed, String col){
        super(name, new Point(STARTING_X, STARTING_Y), size, horSpeed, verSpeed, col, size*2.2, new Herbivore());
        boolean flag = setNeckLength(DEFAULT_NECK_LENGTH);
        if(!flag)
            System.out.println("Giraffe.setNeckLength - error");
        if(col.equals("Natural"))
            loadImages("grf_n_");
        else if(col.equals("Red"))
            loadImages("grf_r_");
        else if(col.equals("Blue"))
            loadImages("grf_b_");
    }

    /**
     * checking validation of the neck length
     * @param neckLength - the neck length we are checking
     * @return true if the neck length is legal
     */
    public static boolean validNeckLength(double neckLength){
        return (neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH);
    }

    /**
     * neck length setter
     * @param neckLength - the neck length you want to set
     * @return true if it succeeds
     */
    public boolean setNeckLength(double neckLength) {
        if(validNeckLength(neckLength))
            this.neckLength = neckLength;
        boolean flag = this.neckLength == neckLength;
        return flag;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.getStartingWeight()
     */
    public double getStartingWeight() {
        return getSize()*2.2;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.getStartingPoint()
     */
    public Point getStartingPoint(){
        return new Point(STARTING_X, STARTING_Y);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.getAnimalName()
     */
    public String getAnimalName(){
        return "Giraffe";
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Chewing.chew()
     */
    public void chew() {
    }
}
