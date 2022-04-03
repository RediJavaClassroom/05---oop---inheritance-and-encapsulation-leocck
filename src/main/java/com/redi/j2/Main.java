package com.redi.j2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // The Animal Kingdom list
        List<Animal> animalKingdom = new ArrayList<>();
        // Adding some animals
        animalKingdom.add(new Animal(BloodType.WARM));
        animalKingdom.add(new Animal(BloodType.COLD));
        animalKingdom.add(new Mammal(15));
        animalKingdom.add(new Dog());
        animalKingdom.add(new Elephant());
        animalKingdom.add(new Fish(1000));
        animalKingdom.add(new Salmon());
        animalKingdom.add(new Shark(false));
        // printing information from all animals
        for (Animal animal : animalKingdom) {

            System.out.println("----------------------------------");
            // gets the name of the most specific class type
            String className = animal.getClass().getSimpleName();
            System.out.println(className.toUpperCase());
            // printing some information from Animal class
            System.out.println("Blood: " + animal.getBloodType());
            System.out.print("Sound: ");
            animal.makeNoise();
            System.out.print("Eat: ");
            animal.eat();
            // printing extra information from extended classes
            if (animal instanceof Mammal) {
                Mammal m = (Mammal) animal;
                System.out.println("Max Babies: " + m.getMaxBabies());
                System.out.print("Walk: ");
                m.walk();
                System.out.println("Give Birth generated: "+m.giveBirth()+" children");
            }
            if (animal instanceof Fish) {
                Fish f = (Fish) animal;
                System.out.println("Max Eggs: " + f.getMaxEggs());
                System.out.print("Swim: ");
                f.swim();
                System.out.println("Lay Eggs generated: "+f.layEggs()+" eggs");
            }
        }
        System.out.println("----------------------------------");
    }
}
