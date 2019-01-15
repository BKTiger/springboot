package com.zhangtai.demo.index.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhangtai.demo.index.dao.IndexMapper;
import com.zhangtai.demo.index.domain.Student;
import com.zhangtai.demo.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangtai
 * @date 2019/1/14 22:37
 * @Description:
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public Student getById(String id) {
        Student byId = indexMapper.getById(id);
        return byId;
    }

    @Override
    public Page<Student> page(Map<String, Object> param) {
        PageHelper.startPage(Integer.parseInt(param.get("page").toString()),Integer.parseInt(param.get("pageSize").toString()));
        Page<Student> page = indexMapper.page();
        long total = page.getTotal();
        return page;
    }

}
