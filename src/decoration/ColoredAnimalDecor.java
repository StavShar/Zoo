package decoration;

import animals.Animal;

public class ColoredAnimalDecor implements ColoredAnimal{
    private Animal animal;
    private String color;

    public ColoredAnimalDecor(Animal a, String c){
        animal = a;
        color = c;
    }

    @Override
    public void changeAnimalColor() {
        String nm = null;
        animal.setColor(color);
        String c = color;
        switch(c) {
            case "Natural":
                color = "n_";
                break;
            case "Blue":
                color = "b_";
                break;
            case "Red":
                color = "r_";
                break;
        }
        switch(animal.getClass().getSimpleName())
        {
            case "Bear":
                nm = "bea_" + color;
                break;
            case "Elephant":
                nm="elf_" + color;
                break;
            case "Giraffe":
                nm = "grf_" + color;
                break;
            case "Lion":
                nm = "lio_" + color;
                break;
            case "Turtle":
                nm = "trt_" + color;
                break;
        }
        animal.loadImages(nm);
        animal.setChanges(true);
    }

}
