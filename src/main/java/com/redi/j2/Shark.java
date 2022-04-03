package com.redi.j2;

public class Shark extends Fish {

    private final boolean isOviparous;

    public Shark(boolean isOviparous) {
        super(20);
        this.isOviparous = isOviparous;
    }

    @Override
    public void eat() {
        System.out.println("This human is delicious");
    }

    @Override
    public int layEggs() {
        if (isOviparous)
            return super.layEggs();
        return 0;
    }
}
