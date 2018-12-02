package com.zhangtai.demo.dao;

import com.zhangtai.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zhangtai
 * @date 2018/12/2 15:21
 * @Description:
 */
public interface MongodbDao extends MongoRepository<Student,String> {

    //根据姓名查询
    List<Student> findByName(String name);

    //根据姓名查询
    List<Student> findByNameLike(String name);

}
