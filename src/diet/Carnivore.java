package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Carnivore implements IDiet{

    @Override
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.MEAT);
    }

    @Override
    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype()))
            animal.setWeight(animal.getWeight() * 1.1);
        return animal.getWeight(); // if food is illegal - returning original weight
    }
}

