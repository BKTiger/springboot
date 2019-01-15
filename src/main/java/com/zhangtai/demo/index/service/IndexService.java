package com.zhangtai.demo.index.service;

import com.github.pagehelper.Page;
import com.zhangtai.demo.index.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @author zhangtai
 * @date 2019/1/14 22:36
 * @Description:
 */
public interface IndexService {
    Student getById(String id);

    Page<Student> page(Map<String, Object> param);
}
