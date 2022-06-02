package factories;

import animals.*;
import graphics.AddAnimalDialog;

/**
 * Factory class to produce herbivoreherbivores
 *
 * @version 1.0 2 June 2022
 * @author Stav Sharabi
 * */
public class HerbivoreFactory implements AnimalFactory{
    private final String[] herbivores = {"Elephant", "Giraffe", "Turtle"};
    private String[] animalData;
    private Animal animal;

    /**
     * factory constructor
     */
    public HerbivoreFactory() {
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
        AddAnimalDialog d = new AddAnimalDialog(herbivores);
        animalData = d.showDialog();
        if (animalData[2].equalsIgnoreCase("Elephant"))
            animal = new Elephant(animalData[0], Integer.parseInt(animalData[3]), Integer.parseInt(animalData[4]), Integer.parseInt(animalData[5]), animalData[1]);
        else if (animalData[2].equalsIgnoreCase("Giraffe"))
            animal = new Giraffe(animalData[0], Integer.parseInt(animalData[3]), Integer.parseInt(animalData[4]), Integer.parseInt(animalData[5]), animalData[1]);
        else if (animalData[2].equalsIgnoreCase("Turtle"))
            animal = new Turtle(animalData[0], Integer.parseInt(animalData[3]), Integer.parseInt(animalData[4]), Integer.parseInt(animalData[5]), animalData[1]);
        return animal;
    }
}
