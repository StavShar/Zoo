package factories;

import animals.Animal;

/**
 * interface of animal factory
 */
public interface AnimalFactory {

    /**
     * producing a new animal and return it
     * @return new animal
     */
    public Animal produceAnimal();
}
