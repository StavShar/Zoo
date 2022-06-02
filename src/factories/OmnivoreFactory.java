package factories;

import animals.Animal;
import animals.Bear;
import graphics.AddAnimalDialog;

/**
 * Factory class to produce omnivore animals
 *
 * @version 1.0 2 June 2022
 * @author Stav Sharabi
 * */
public class OmnivoreFactory implements AnimalFactory {
    private final String[] omnivors = {"Bear"};
    private String[] animalData;
    private Animal animal;

    /**
     * factory constructor
     */
    public OmnivoreFactory() {
        animalData = null;
        animal = null;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see factories.AnimalFactory.produceAnimal()
     */
    public Animal produceAnimal() {
        AddAnimalDialog d = new AddAnimalDialog(omnivors);
        animalData = d.showDialog();
        if (animalData[2].equalsIgnoreCase("Bear"))
            animal = new Bear(animalData[0], Integer.parseInt(animalData[3]), Integer.parseInt(animalData[4]), Integer.parseInt(animalData[5]), animalData[1]);
        return animal;
    }
}