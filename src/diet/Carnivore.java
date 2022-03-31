package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Carnivore implements IDiet{

    private final double WEIGHT_GROW = 1.1; //10%

    @Override
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.MEAT);
    }

    @Override
    public double eat(Animal animal, IEdible food) {
        double weight = animal.getWeight();
        if (canEat(food.getFoodtype()))
            animal.setWeight(weight * WEIGHT_GROW);
        return animal.getWeight() - weight; // returning how much weight added
    }
}

