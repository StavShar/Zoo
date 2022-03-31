package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;

import java.util.Random;
import java.util.random.*;
import java.util.Scanner;
import static mobility.Point.checkBounderies;


public class ZooActions {

    public static void main(String[] args) {
        int x, y, size = 0;
        boolean flag;
        Scanner sc = new Scanner(System.in);
        while(size<3) {
            System.out.println("Enter number of animals: ");
            size = sc.nextInt();
            if(size<3)
                System.out.println("It must be higher than 3, try again.");
        }
        Animal[] list = new Animal[size];
        for(int i = 0 ; i < size ; i++)//create animals
            list[i] = createAnimal();

        for(int i = 0 ; i < size ; i++) {//move animals
            while(true){
                System.out.println("Where do you want to move?\nEnter x coordinate:");
                x = sc.nextInt();
                System.out.println("Enter y coordinate:");
                y = sc.nextInt();
                if (checkBounderies(new Point(x, y))){
                    flag = move(list[i], new Point(x, y));
                    if(flag)
                        System.out.println("animal moved successfully.");
                    else
                        System.out.println("animal move failed.");
                    break;
                }
                else
                    System.out.println("Illegal point, please try again");
        }
        }

        for(int i = 0 ; i < size/2 ; i++) {//random eat
            Random random = new Random();
            int animal1 = random.nextInt(size), animal2 = random.nextInt(size);
            while(animal1 == animal2)
                animal2 = random.nextInt(size);
            if(eat(list[animal1], list[animal2]))
                System.out.println("animal eat successfully.");
            else
                System.out.println("animal eat failed.");
        }
    }

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
                return new Lion(name, p);
            else
                return new Lion(name);
        } else if (option == 2) {//Bear
            String furColor;
            System.out.println("Enter fur color: ");
            furColor = sc.next();
            if (p != null)
                return new Bear(name, p, furColor);
            else
                return new Bear(name);
        } else if (option == 3) {//Giraffe
            double neckLength;
            System.out.println("Enter neck length: ");
            neckLength = sc.nextDouble();
            if (p != null)
                return new Giraffe(name, p, neckLength);
            else
                return new Giraffe(name);
        } else if (option == 4) {//Elephant
            double trunkLength;
            System.out.println("Enter trunk length: ");
            trunkLength = sc.nextDouble();
            if (p != null)
                return new Elephant(name, p, trunkLength);
            else
                return new Elephant(name);
        } else if (option == 5) {//Turtle
            int age;
            System.out.println("Enter trunk length: ");
            age = sc.nextInt();
            if (p != null)
                return new Turtle(name, p, age);
            else
                return new Turtle(name);
        }
        return null;//this return will never be used
    }

    public static boolean eat(Object animal, IEdible food){
        boolean flag = false;
        if(animal instanceof Animal){
            flag = ((Animal) animal).eat(food);
        }
        return flag;
    }

    public static boolean move(Object animal, Point point){
        double distance;
        if(checkBounderies(point)){
            if(animal instanceof Animal) {
                distance = ((Animal) animal).move(point);
                return distance != 0; //return false if distance = 0
            }
        }
        return false;
    }

}
