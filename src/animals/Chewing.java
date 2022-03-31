package animals;

import mobility.Point;

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
