package com.zhangtai.demo.common.returnobj;

import java.util.List;

/**
 * @author zhangtai
 * @date 2018/12/5 21:50
 * @Description:
 */
public class DataResult<E> {
    private int total;
    private List<E> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
