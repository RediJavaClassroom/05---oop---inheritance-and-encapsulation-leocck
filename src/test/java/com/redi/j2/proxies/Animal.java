package com.redi.j2.proxies;

import com.redi.j2.BloodType;
import com.redi.j2.utils.ReflectionProxy;

public class Animal extends ReflectionProxy {

    public Animal(BloodType bloodType) {
        super(new Object[] {bloodType});
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Animal";
    }

    public BloodType getBloodType() {
        return invokeMethod("getBloodType", new Class[]{}, new Object[]{});
    }

    public void eat() {
        invokeMethod("eat", new Class[]{}, new Object[]{});
    }

    public void makeNoise() {
        invokeMethod("makeNoise", new Class[]{}, new Object[]{});
    }
}
