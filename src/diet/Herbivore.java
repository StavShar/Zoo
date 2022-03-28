package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Herbivore implements IDiet{

    private final double WEIGHT_GROW = 1.07; //7%

    @Override
    public boolean canEat(EFoodType food) {
        return food.equals(EFoodType.VEGETABLE);
    }

    @Override
    public double eat(Animal animal, IEdible food) {
        double weight = animal.getWeight();
        if (canEat(food.getFoodtype()))
            animal.setWeight(animal.getWeight() * WEIGHT_GROW);
        return animal.getWeight() - weight; // returning how much weight added
    }
}
