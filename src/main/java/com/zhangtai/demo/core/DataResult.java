package com.zhangtai.demo.core;

import lombok.Data;

import java.util.List;

/**
 * @author zhangtai
 * @date 2018/12/2 15:20
 * @Description:
 */
@Data
public class DataResult<E> {
    private List<E> list;
    private int total;

}
