package com.redi.j2;

public class Animal {

    private final BloodType bloodType;

    public BloodType getBloodType() {
        return bloodType;
    }

    public Animal(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public void eat() {
        System.out.println("chomp chomp");
    }

    public void makeNoise() {
        System.out.println("making some noise");
    }
}
