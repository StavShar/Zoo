package diet;

import food.*;
import animals.Animal;

/**
 * interface of diets
 */
public interface IDiet {

    /**
     * checking if "this" can eat this type of food
     * @param food - food type
     * @return true if "this" can eat that type of food
     */
    boolean canEat(EFoodType food);

    /**
     * this method makes animal eats the food, and update his weight
     * @param animal - the animal who eats the food
     * @param food - the food
     * @return the change of weight
     */
    double eat(Animal animal, IEdible food);
}
