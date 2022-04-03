package com.redi.j2;

public class Salmon extends Fish {

    private boolean hasLaidEggs = false;

    public Salmon() {
        super(2800);
    }

    @Override
    public int layEggs() {
        if (!hasLaidEggs) {
            hasLaidEggs = true;
            return super.layEggs();
        }
        return 0;
    }

    @Override
    public void eat() {
        System.out.println("This small pray is delicious");
    }
}
