package animals;

import diet.Carnivore;
import diet.IDiet;
import mobility.Point;

/**
 *Abstract class to implement makeSound() for all the roaring animals
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Roaring extends Animal{

    /**
     * constructor of roaring animal
     * @param name - name of the animal
     * @param p - the point where the animal
     */
    public Roaring(String name, Point p){
        super(name, p);
    }

    /**
     * constructor of roaring animal
     * @param name - name of the animal
     * @param p - point of the animal location
     * @param size - size of the animal(measured with pixels)
     * @param horSpeed - horizontal speed of the animal
     * @param verSpeed - vertical speed of the animal
     * @param col - color of the animal
     */
    public Roaring(String name, Point p, int size, int horSpeed, int verSpeed, String col, double weight, IDiet diet){
        super(name, p, size, horSpeed, verSpeed, col, weight, diet);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see animals.Animal.makeSound()
     */
    public void makeSound() {
        roar();
    }

    /**
     * the sound of the animal while he eats
     */
    public abstract void roar();

}
