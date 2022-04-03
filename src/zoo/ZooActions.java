package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Random;
import java.util.random.*;
import java.util.Scanner;

import static animals.Bear.validFurColor;
import static animals.Elephant.validTrunkLength;
import static animals.Giraffe.validNeckLength;
import static animals.Turtle.validAge;
import static mobility.Point.checkBounderies;


/**
 *Representing our zoo behavior with all the actions
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class ZooActions {

    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        int x, y, size = 0;
        boolean flag;
        Scanner sc = new Scanner(System.in);
        while (size < 3) {
            System.out.println("Enter number of animals: ");
            size = sc.nextInt();
            if (size < 3)
                System.out.println("It must be higher than 3, try again.");
        }
        Animal[] list = new Animal[size];
        for (int i = 0; i < size; i++)//create animals
            list[i] = createAnimal();

        for (int i = 0; i < size; i++) {//move animals
            while (true) {
                System.out.println("Where do you want to move?\nEnter x coordinate:");
                x = sc.nextInt();
                System.out.println("Enter y coordinate:");
                y = sc.nextInt();
                if (checkBounderies(new Point(x, y))) {
                    flag = move(list[i], new Point(x, y));
                    if (flag)
                        System.out.println("animal moved successfully.");
                    else
                        System.out.println("animal move failed.");
                    break;
                } else
                    System.out.println("Illegal point, please try again");
            }
        }

        for (int i = 0; i < size / 2; i++) {//random eat
            Random random = new Random();
            int animal1 = random.nextInt(size), animal2 = random.nextInt(size);
            while (animal1 == animal2)
                animal2 = random.nextInt(size);
            if (eat(list[animal1], list[animal2]))
                System.out.println("animal eat successfully.");
            else
                System.out.println("animal eat failed.");
        }
    }

    /**
     * creating one of the animals from the zoo
     * @return the new animal
     */
    private static Animal createAnimal() {
        int option = 0;
        Animal animal = null;
        Point p = null;
        Scanner sc = new Scanner(System.in);
        while (!(option >= 1 && option <= 5)) {
            System.out.println("1-Lion\n2-Bear\n3-Giraffe\n4-Elephant\n5-Turtle");
            option = sc.nextInt();
            if (!(option >= 1 && option <= 5))
                System.out.println("Wrong option, please try again.");
        }
        String name;
        int x, y;
        System.out.println("Enter name:");
        name = sc.next();
        System.out.println("Enter x coordinate:");
        x = sc.nextInt();
        System.out.println("Enter y coordinate:");
        y = sc.nextInt();
        if (checkBounderies(new Point(x, y)))
            p = new Point(x, y);
        else
            System.out.println("Illegal point, default point are set.");
        if (option == 1) {//Lion
            if (p != null)
                animal =  new Lion(name, p);
            else
                animal = new Lion(name);
        }
        else if (option == 2) {//Bear
            String furColor;
            System.out.println("Enter fur color: ");
            furColor = sc.next();
            if (p != null && validFurColor(furColor))
                animal = new Bear(name, p, furColor);
            else if(p != null)
                animal = new Bear(name, p);
            else
                animal = new Bear(name);
        }
        else if (option == 3) {//Giraffe
            double neckLength;
            System.out.println("Enter neck length: ");
            neckLength = sc.nextDouble();
            if (p != null && validNeckLength(neckLength))
                animal = new Giraffe(name, p, neckLength);
            else if(p != null)
                animal = new Giraffe(name, p);
            else
                animal = new Giraffe(name);
        }
        else if (option == 4) {//Elephant
            double trunkLength;
            System.out.println("Enter trunk length: ");
            trunkLength = sc.nextDouble();
            if (p != null && validTrunkLength(trunkLength))
                animal = new Elephant(name, p, trunkLength);
            else if (p != null)
                animal = new Elephant(name, p);
            else
                animal = new Elephant(name);
        }
        else if (option == 5) {//Turtle
            int age;
            System.out.println("Enter trunk length: ");
            age = sc.nextInt();
            if (p != null && validAge(age))
                animal = new Turtle(name, p, age);
            else if(p != null)
                animal = new Turtle(name, p);
            else
                animal = new Turtle(name);
        }
        return animal;
    }

    /**
     * static function of eatting
     * @param animal - the animal who eats
     * @param food - the food
     * @return true if eating succeed
     */
    public static boolean eat(Object animal, IEdible food){
        boolean flag = false;

        /*if( animal instanceof Animal)
            flag = ((Animal) animal).eat(food);*/

        if( animal instanceof Lion)
            flag = ((Lion) animal).eat(food);
        else if( animal instanceof Bear)
            flag = ((Bear) animal).eat(food);
        else if( animal instanceof Giraffe)
            flag = ((Giraffe) animal).eat(food);
        else if( animal instanceof Elephant)
            flag = ((Elephant) animal).eat(food);
        else if( animal instanceof Turtle)
            flag = ((Turtle) animal).eat(food);

        return flag;
    }

    /**
     * static function of moving in the zoo
     * @param animal - the animal who moves
     * @param point - the new location the animal moves to
     * @return true if moving succeed
     */
    public static boolean move(Object animal, Point point){
        double distance = 0, weight;
        String name;
        if(checkBounderies(point)){
            /*if(animal instanceof Animal) {
                weight = ((Animal) animal).getWeight();
                distance = ((Animal) animal).move(point);
                weight = weight-(distance*weight*0.00025);
                ((Animal) animal).setWeight(weight);
                MessageUtility.logBooleanFunction(((Animal) animal).getName(), "move", point, distance != 0);
                return distance != 0; //return false if distance = 0
            }*/
            if(animal instanceof Animal){
                name = ((Animal) animal).getName();
                if(animal instanceof Lion){
                    Lion lion = (Lion) animal;
                    weight = lion.getWeight();
                    distance = lion.move(point);
                    weight = weight-(distance*weight*0.00025);
                    lion.setWeight(weight);
                }
                else if(animal instanceof Bear){
                    Bear bear = (Bear) animal;
                    weight = bear.getWeight();
                    distance = bear.move(point);
                    weight = weight-(distance*weight*0.00025);
                    bear.setWeight(weight);
                }
                else if(animal instanceof Giraffe){
                    Giraffe giraffe = (Giraffe) animal;
                    weight = giraffe.getWeight();
                    distance = giraffe.move(point);
                    weight = weight-(distance*weight*0.00025);
                    giraffe.setWeight(weight);
                }
                else if(animal instanceof Elephant){
                    Elephant elephant = (Elephant) animal;
                    weight = elephant.getWeight();
                    distance = elephant.move(point);
                    weight = weight-(distance*weight*0.00025);
                    elephant.setWeight(weight);
                }
                else if(animal instanceof Turtle){
                    Turtle turtle = (Turtle) animal;
                    weight = turtle.getWeight();
                    distance = turtle.move(point);
                    weight = weight-(distance*weight*0.00025);
                    turtle.setWeight(weight);
                }
            MessageUtility.logBooleanFunction(name, "move", point, distance != 0);
            return distance != 0; //return false if distance = 0
            }
        }
        return false;
    }

}
