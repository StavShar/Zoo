package animals;

import mobility.Point;

/**
 *Abstract class to implement makeSound() for all the chewing animals
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Chewing extends Animal{

    /**
     * constructor of Chewing animal
     * @param name - name of the animal
     * @param p - the point where the animal
     */
    public Chewing(String name, Point p){
        super(name, p);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.makeSound()
     */
    public void makeSound() {
        chew();
    }

    /**
     * the sound of the animal while he eats
     */
    public abstract void chew();
}
