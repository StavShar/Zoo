package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

/**
 *Representing Omnivore diet
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Omnivore implements IDiet{
    IDiet car = new Carnivore();
    IDiet herb = new Herbivore();

    @Override
    /*
     * (non-Javadoc)
     *
     * @see diet.IDiet.canEat()
     */
    public boolean canEat(EFoodType food) {
        return car.canEat(food) || herb.canEat(food);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see diet.IDiet.eat()
     */
    public double eat(Animal animal, IEdible food) {
        if(canEat(food.getFoodtype())){
            IDiet diet = null;
            if(food.getFoodtype().equals(EFoodType.MEAT))
                diet = car;
            else if(food.getFoodtype().equals(EFoodType.VEGETABLE))
                diet = herb;
            if(diet != null)
                return diet.eat(animal, food);
        }
        return 0; // food is illegal - weight doesn't changed(return 0)
    }
}
