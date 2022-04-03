package com.redi.j2.proxies;

import com.redi.j2.BloodType;
import com.redi.j2.utils.ReflectionProxy;

public class Mammal extends ReflectionProxy {

    public Mammal(int maxBabies) {
        super(new Object[]{maxBabies});
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Mammal";
    }

    public BloodType getBloodType() {
        return invokeMethod("getBloodType", new Class[]{}, new Object[]{});
    }

    public Integer getMaxBabies() {
        return invokeMethod("getMaxBabies", new Class[]{}, new Object[]{});
    }

    public void walk() {
        invokeMethod("walk", new Class[]{}, new Object[]{});
    }

    public Integer giveBirth() {
        return invokeMethod("giveBirth", new Class[]{}, new Object[]{});
    }
}
