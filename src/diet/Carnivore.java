package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

/**
 *Representing Carnivore diet
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Carnivore implements IDiet{

    private final double WEIGHT_GROW = 1.1; //10%

    @Override
    /*
     * (non-Javadoc)
     *
     * @see diet.IDiet.canEat()
     */
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.MEAT);
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
            animal.setWeight(weight * WEIGHT_GROW);
        return animal.getWeight() - weight; // returning how much weight added
    }
}

