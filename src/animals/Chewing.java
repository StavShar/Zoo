package animals;

import mobility.Point;

/**
 *Abstract class to implement makeSound() for all the chewing animals
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public abstract class Chewing extends Animal{

    public Chewing(String name, Point p){
        super(name, p);
    }

    @Override
    public void makeSound() {
        chew();
    }

    public abstract void chew();
}
