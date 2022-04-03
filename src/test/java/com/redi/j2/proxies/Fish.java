package com.redi.j2.proxies;

import com.redi.j2.BloodType;
import com.redi.j2.utils.ReflectionProxy;

public class Fish extends ReflectionProxy {
    public Fish(int maxEggs) {
        super(new Object[]{maxEggs});
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Fish";
    }

    public BloodType getBloodType() {
        return invokeMethod("getBloodType", new Class[]{}, new Object[]{});
    }

    public Integer getMaxEggs() {
        return invokeMethod("getMaxEggs", new Class[]{}, new Object[]{});
    }

    public void swim() {
        invokeMethod("swim", new Class[]{}, new Object[]{});
    }

    public Integer layEggs() {
        return invokeMethod("layEggs", new Class[]{}, new Object[]{});
    }
}
