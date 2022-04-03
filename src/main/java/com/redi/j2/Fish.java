package com.redi.j2;

import java.util.Random;

public class Fish extends Animal{

    private final int maxEggs;

    public int getMaxEggs() {
        return maxEggs;
    }

    public Fish(int maxEggs) {
        super(BloodType.COLD);
        this.maxEggs = maxEggs;
    }

    public void swim() {
        System.out.println("keep on swimming");
    }

    public int layEggs() {
        Random rn = new Random();
        return rn.nextInt(maxEggs)+1;
    }
}
