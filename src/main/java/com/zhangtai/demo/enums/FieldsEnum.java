package com.zhangtai.demo.enums;

/**
 * @author zhangtai
 * @date 2020/1/8 16:00
 * @Description:
 */
public enum FieldsEnum {
    // ES的字段类型
    TEXT("text"),
    LONG("long"),
    DOUBLE("double"),
    DATE("date"),
    OTHER("");

    private String value;

    private FieldsEnum(String value){
        this.value = value;
    }
    public String value(){
        return value;
    }
}
