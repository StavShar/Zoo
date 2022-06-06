package animals;

import diet.Omnivore;
import mobility.Point;

/**
 *Specific class who representing bear
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Bear extends Roaring{
    private static final int STARTING_X = 100;
    private static final int STARTING_Y = 5;
    private static final double STARTING_WEIGHT = 308.2;
    private static final String DEFAULT_FUR_COLOR = "GRAY";
    private String furColor;

    /**
     * constructor of Bear with name only
     * @param name - name of the Bear
     */
    public Bear(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setFurColor(DEFAULT_FUR_COLOR);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    /**
     * constructor of Bear with 2 parameters
     * @param name - name of the Bear
     * @param p - the point where the Bear
     */
    public Bear(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setFurColor(DEFAULT_FUR_COLOR);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    /**
     * constructor of Bear with 3 parameters
     * @param name - name of the Bear
     * @param p - the point where the Bear
     * @param furColor - the fur color of the Bear
     */
    public Bear(String name, Point p, String furColor){
        super(name, p);
        boolean flag;
        if(validFurColor(furColor)){
            flag = setFurColor(furColor);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        }
        else {
            System.out.println("Illegal fur color, default fur color are set.");
            flag = setFurColor(DEFAULT_FUR_COLOR);
            if(!flag)
                System.out.println("Bear.setFurColor - error");
        }
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Bear.setWeight - error");
        flag = setDiet(new Omnivore());
        if(!flag)
            System.out.println("Bear.setDiet - error");
    }

    /**
     * bear constructor for hw2
     * @param name - name of the animal
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Bear(String name, int size, int horSpeed, int verSpeed, String col){
        super(name, new Point(STARTING_X, STARTING_Y), size, horSpeed, verSpeed, col, size*1.5, new Omnivore());
        boolean flag = setFurColor(DEFAULT_FUR_COLOR);
        if(!flag)
            System.out.println("Bear.setFurColor - error");
        if(col.equals("Natural"))
            loadImages("bea_n_");
        else if(col.equals("Red"))
            loadImages("bea_r_");
        else if(col.equals("Blue"))
            loadImages("bea_b_");
    }

    /**
     * fur color setter
     * @param furColor - the fur color you want to set
     * @return true if it succeeds
     */
    public boolean setFurColor(String furColor) {
        if(validFurColor(furColor))
            this.furColor = furColor;
        boolean flag = this.furColor.equals(furColor);
        return flag;
    }

    /**
     * checking validation of the fur color
     * @param furColor - the fur color we are checking
     * @return true if the fur color is legal
     */
    public static boolean validFurColor(String furColor){
        return (furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY"));
    }

    @Override
    /*
    * (non-Javadoc)
    *
    * @see animals.Animal.getStartingWeight()
    */
    public double getStartingWeight() {
        return getSize()*1.5;
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
     return "Bear";
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Roaring.roar()
     */
    public void roar() {
    }
}
