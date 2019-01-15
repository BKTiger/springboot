package com.zhangtai.demo.index.dao;

import com.github.pagehelper.Page;
import com.zhangtai.demo.index.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangtai
 * @date 2019/1/14 22:48
 * @Description:
 */
@Mapper
public interface IndexMapper {

Student getById(String id);
Page<Student> page();

}
