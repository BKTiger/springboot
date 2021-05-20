package com.zhangtai.demo.verification.extents;

public class TestBaseVO extends BaseVO {

    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String tostr() {
        return getA()+b;
    }
}
