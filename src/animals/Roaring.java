package animals;

import mobility.Point;

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
