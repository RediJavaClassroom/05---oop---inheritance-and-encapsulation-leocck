package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class Salmon  extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Salmon";
    }

    public Integer getMaxEggs() {
        return invokeMethod("getMaxEggs", new Class[]{}, new Object[]{});
    }

    public Integer layEggs() {
        return invokeMethod("layEggs", new Class[]{}, new Object[]{});
    }

    public void eat() {
        invokeMethod("eat", new Class[]{}, new Object[]{});
    }
}