package animals;

import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import java.util.Random;

/**
 *Specific class who representing Lion
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Lion extends Roaring{
    private static final int STARTING_X = 20;
    private static final int STARTING_Y = 0;
    private static final double STARTING_WEIGHT = 408.2;
    private static final int SCAR_CHANCE = 50; // percentage
    private int scarCount;

    /**
     * constructor of Lion with name only
     * @param name - name of the Lion
     */
    public Lion(String name){
        super(name, new Point(STARTING_X, STARTING_Y));
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Lion.setWeight - error");
        flag = setDiet(new Carnivore());
        if(!flag)
            System.out.println("Lion.setDiet - error");
        scarCount = 0;
    }

    /**
     * constructor of Lion with 2 parameters
     * @param name - name of the Lion
     * @param p - the point where the Lion
     */
    public Lion(String name, Point p){
        super(name, p);
        boolean flag;
        flag = setWeight(STARTING_WEIGHT);
        if(!flag)
            System.out.println("Lion.setWeight - error");
        flag = setDiet(new Carnivore());
        if(!flag)
            System.out.println("Lion.setDiet - error");
        scarCount = 0;
    }

    /**
     * lion constructor for hw2
     * @param name - name of the animal
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Lion(String name, int size, int horSpeed, int verSpeed, String col){
        super(name, new Point(STARTING_X, STARTING_Y), size, horSpeed, verSpeed, col, size*0.8, new Carnivore());
        scarCount = 0;
        if(col.equals("Natural"))
            loadImages("lio_n_");
        else if(col.equals("Red"))
            loadImages("lio_r_");
        else if(col.equals("Blue"))
            loadImages("lio_b_");
    }

    /**
     * returning the scar count
     * @return scarCount
     */
    public int getScarCount() {
        return scarCount;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object.Clone()
     */
    public Object clone()  {
        Lion clone = null;
        clone = (Lion) super.clone();
        clone.setWeight(clone.getSize()*0.8);
        clone.setLocation(new Point(STARTING_X, STARTING_Y));
        clone.setChanges(true);
        return clone;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.getAnimalName()
     */
    public String getAnimalName(){
        return "Lion";
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.eat()
     */
    public boolean eat(IEdible food) {
        if(super.eat(food)){
            Random rand = new Random();
            if(rand.nextInt(1,100) <= SCAR_CHANCE)
                scarCount++;
            return true;
        }
        //else
        return false;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.getFoodType()
     */
    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
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
