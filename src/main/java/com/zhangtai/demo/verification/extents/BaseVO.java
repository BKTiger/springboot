package com.zhangtai.demo.verification.extents;

public abstract class BaseVO {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public abstract String tostr();
}
