package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Herbivore implements IDiet{

    @Override
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.VEGETABLE);
    }

    @Override
    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype()))
            animal.setWeight(animal.getWeight() * 1.07);
        return animal.getWeight(); // if food is illegal - returning original weight
    }
}
