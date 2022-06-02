package factories;

import animals.Animal;
import animals.Lion;
import graphics.AddAnimalDialog;

/**
 * Factory class to produce carnivore animals
 *
 * @version 1.0 2 June 2022
 * @author Stav Sharabi
 * */
public class CarnivoreFactory implements AnimalFactory{
    private final String[] carnivors = {"Lion"};
    private String[] animalData;
    private Animal animal;

    /**
     * factory constructor
     */
    public CarnivoreFactory(){
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
        AddAnimalDialog d = new AddAnimalDialog(carnivors);
        animalData = d.showDialog();
        if(animalData[2].equalsIgnoreCase("Lion"))
            animal = new Lion(animalData[0], Integer.parseInt(animalData[3]), Integer.parseInt(animalData[4]), Integer.parseInt(animalData[5]), animalData[1]);
        return animal;
    }

}
