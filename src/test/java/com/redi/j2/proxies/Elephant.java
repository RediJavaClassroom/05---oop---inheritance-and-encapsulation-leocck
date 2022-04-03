package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class Elephant extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Elephant";
    }

    public Integer getMaxBabies() {
        return invokeMethod("getMaxBabies", new Class[]{}, new Object[]{});
    }

    public void makeNoise() {
        invokeMethod("makeNoise", new Class[]{}, new Object[]{});
    }

    public void eat() {
        invokeMethod("eat", new Class[]{}, new Object[]{});
    }
}
