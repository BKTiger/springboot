package com.zhangtai.demo.Service;

import com.zhangtai.demo.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zhangtai
 * @date 2018/12/2 15:33
 * @Description:
 */
public interface MongodbService {
    List<Student> findAll();
    void add(Student student);
    void update(Student student);
    void delete(String id);
    Page<Student> findAllByPage(int page,int size);
    List<Student> findLikeName(String name);
}
