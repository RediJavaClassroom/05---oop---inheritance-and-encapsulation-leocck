package com.redi.j2;

public class Dog extends Mammal {

    public Dog() {
        super(24);
    }

    @Override
    public void eat() {
        System.out.println("This bone is delicious");
    }

    @Override
    public void makeNoise() {
        System.out.println("woof woof");
    }
}
