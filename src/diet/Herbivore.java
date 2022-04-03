package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;


/**
 *Representing Herbivore diet
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Herbivore implements IDiet{

    private final double WEIGHT_GROW = 1.07; //7%

    @Override
    /*
     * (non-Javadoc)
     *
     * @see diet.IDiet.canEat()
     */
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.VEGETABLE);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see diet.IDiet.eat()
     */
    public double eat(Animal animal, IEdible food) {
        double weight = animal.getWeight();
        if (canEat(food.getFoodtype()))
            animal.setWeight(animal.getWeight() * WEIGHT_GROW);
        return animal.getWeight() - weight; // returning how much weight added
    }
}
