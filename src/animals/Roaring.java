package animals;

import mobility.Point;

/**
 *Abstract class to implement makeSound() for all the roaring animals
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Roaring extends Animal{

    Roaring(String name, Point p){
        super(name, p);
    }

    @Override
    public void makeSound() {
        roar();
    }
    public abstract void roar();

}
