package animals;

import diet.Herbivore;
import mobility.Point;

/**
 *Specific class who representing Elephant
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Elephant extends Chewing{
    private static final int STARTING_X = 50;
    private static final int STARTING_Y = 90;
    private static final double STARTING_WEIGHT = 500;
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double DEFAULT_TRUNK_LENGTH = 1;
    private double trunkLength;

    /**
     * constructor of Elephant with name only
     * @param name - name of the Elephant
     */
    public Elephant(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
        if(!flag)
            System.out.println("Elephant.setTrunkLength - error");
    }

    /**
     * constructor of Elephant with 2 parameters
     * @param name - name of the Elephant
     * @param p - the point where the Elephant
     */
    public Elephant(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
        if(!flag)
            System.out.println("Elephant.setTrunkLength - error");
    }

    /**
     * constructor of Elephant with 3 parameters
     * @param name - name of the Elephant
     * @param p - the point where the Elephant
     * @param trunkLength - the trunk length of the Elephant
     */
    public Elephant(String name, Point p, double trunkLength){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Elephant.setWeight - error");
        flag = setDiet(new Herbivore());
        if(!flag)
            System.out.println("Elephant.setDiet - error");
        if(validTrunkLength(trunkLength)){
            flag = setTrunkLength(trunkLength);
            if(!flag)
                System.out.println("Elephant.setTrunkLength - error");
        }
        else {
            flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
            if(!flag)
                System.out.println("Elephant.setTrunkLength - error");
        }
    }

    /**
     * elephant constructor for hw2
     * @param name - name of the animal
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Elephant(String name, int size, int horSpeed, int verSpeed, String col){
        super(name, new Point(STARTING_X, STARTING_Y), size, horSpeed, verSpeed, col, size*10, new Herbivore());
        boolean flag = setTrunkLength(DEFAULT_TRUNK_LENGTH);
        if(!flag)
            System.out.println("Bear.setTrunkLength - error");
        if(col.equals("Natural"))
            loadImages("elf_n_");
        else if(col.equals("Red"))
            loadImages("elf_r_");
        else if(col.equals("Blue"))
            loadImages("elf_b_");
    }

    /**
     * checking validation of the trunk length
     * @param trunkLength - the trunk length we are checking
     * @return true if the trunk length is legal
     */
    public static boolean validTrunkLength(double trunkLength){
        return (trunkLength > MIN_TRUNK_LENGTH && trunkLength < MAX_TRUNK_LENGTH);
    }

    /**
     * trunk length setter
     * @param trunkLength - the trunk length you want to set
     * @return true if it succeeds
     */
    public boolean setTrunkLength(double trunkLength) {
        if(validTrunkLength(trunkLength))
            this.trunkLength = trunkLength;
        boolean flag = this.trunkLength == trunkLength;
        return flag;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.getStartingWeight()
     */
    public double getStartingWeight() {
        return getSize()*10;
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
        return "Elephant";
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
