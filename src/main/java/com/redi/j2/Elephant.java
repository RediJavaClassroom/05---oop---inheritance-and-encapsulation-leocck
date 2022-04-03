package com.redi.j2;

public class Elephant extends Mammal {

    public Elephant() {
        super(2);
    }

    @Override
    public void eat() {
        System.out.println("This hay is delicious");
    }

    @Override
    public void makeNoise() {
        System.out.println("bahruuuuuuhhhhaaaaa");
    }
}
