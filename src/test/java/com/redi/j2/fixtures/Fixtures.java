package com.redi.j2.fixtures;

import com.redi.j2.BloodType;
import com.redi.j2.proxies.*;

import java.util.Random;

public class Fixtures {

    public static Animal createAnimal() {
        return createAnimal(BloodType.COLD);
    }

    public static Animal createAnimal(BloodType type) {
        return new Animal(type);
    }

    public static Mammal createMammal() {
        Random rn = new Random();
        return createMammal(rn.nextInt(15) + 1);
    }

    public static Mammal createMammal(int maxBabies) {
        return new Mammal(maxBabies);
    }

    public static Dog createDog() {
        return new Dog();
    }

    public static Elephant createElephant() {
        return new Elephant();
    }

    public static Fish createFish() {
        Random rn = new Random();
        return createFish(rn.nextInt(1000) + 1);
    }

    public static Fish createFish(int maxEggs) {
        return new Fish(maxEggs);
    }

    public static Salmon createSalmon() {
        return new Salmon();
    }

    public static Shark createShark() {
        return createShark(false);
    }

    public static Shark createShark(boolean isOviparous) {
        return new Shark(isOviparous);
    }
}
