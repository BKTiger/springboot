package com.zhangtai.demo.verification.extents;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaseTest {

    public static void main(String[] args) {
        TestBaseVO baseVO = new TestBaseVO();
        baseVO.setA("1111");
        baseVO.setB("2222");
        String s = JSONObject.toJSONString(baseVO);
        BaseVO baseVO1 = JSON.parseObject(s, BaseVO.class);

        System.out.println(baseVO1.tostr());
    }
}
