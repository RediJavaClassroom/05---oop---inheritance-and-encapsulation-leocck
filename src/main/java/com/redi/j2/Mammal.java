package com.redi.j2;

import java.util.Random;

public class Mammal extends Animal {

    private final int maxBabies;

    public int getMaxBabies() {
        return maxBabies;
    }

    public Mammal(int maxBabies) {
        super(BloodType.WARM);
        this.maxBabies = maxBabies;
    }

    public void walk() {
        System.out.println("going for a walk");
    }

    public int giveBirth() {
        Random rn = new Random();
        return rn.nextInt(maxBabies)+1;
    }
}
