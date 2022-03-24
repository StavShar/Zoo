package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Omnivore implements IDiet{

    @Override
    public boolean canEat(EFoodType food) {
        IDiet car = new Carnivore();
        IDiet herb = new Herbivore();
        return car.canEat(food) || herb.canEat(food);
    }

    @Override
    public double eat(Animal animal, IEdible food) {
        if(canEat(food.getFoodtype())){
            IDiet diet = null;
            if(food.getFoodtype().equals(EFoodType.MEAT))
                diet = new Carnivore();
            else if(food.getFoodtype().equals(EFoodType.VEGETABLE))
                diet = new Herbivore();
            if(diet != null)
                return diet.eat(animal, food);
        }
        return animal.getWeight(); // food is illegal - returning original weight
    }
}
