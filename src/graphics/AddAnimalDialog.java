package graphics;

import animals.*;

import javax.swing.*;

import static animals.Animal.*;

public class AddAnimalDialog extends JDialog {
    private static int count = 0;
    private String animals[] = {"Lion", "Bear", "Elephant", "Giraffe", "Turtle"}, col, type;
    private int size, verSpeed, horSpeed;

    public Animal AddAnimal(){
        //(String name, int size, int horSpeed, int verSpeed, String col, IDiet diet)
        Animal animal = null;
        String name = "Animal"+Integer.toString(count);
        count++;
        boolean flag = false;
        for(int i=0; i<animals.length; i++)
            if (animals[i].equals(type)) {
                flag = true;
                break;
            }
        if(!validColor(col))
            flag = false;
        if(!validSize(size))
            flag = false;
        if(!validVerSpeed(verSpeed))
            flag = false;
        if(!validHorSpeed(horSpeed))
            flag = false;
        if(flag){
            switch (type){
                case "Lion": animal = new Lion(name, size, horSpeed, verSpeed, col);
                case "Bear": animal = new Bear(name, size, horSpeed, verSpeed, col);
                case "Elephant": animal = new Elephant(name, size, horSpeed, verSpeed, col);
                case "Giraffe": animal = new Giraffe(name, size, horSpeed, verSpeed, col);
                case "Turtle": animal = new Turtle(name, size, horSpeed, verSpeed, col);
            }
        }
        return animal;//returning animal reference only if all the parameters are legal
    }
}
