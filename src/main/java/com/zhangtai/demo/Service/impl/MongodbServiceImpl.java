package com.zhangtai.demo.Service.impl;

import com.zhangtai.demo.Service.MongodbService;
import com.zhangtai.demo.dao.MongodbDao;
import com.zhangtai.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zhangtai
 * @date 2018/12/2 15:34
 * @Description:
 */
@Service
public class MongodbServiceImpl implements MongodbService {

    @Autowired
   private MongodbDao mongodbDao;

    @Override
    public List<Student> findAll() {
        return mongodbDao.findAll();
    }

    @Override
    public void add(Student student) {
        mongodbDao.save(student);
    }

    @Override
    public void update(Student student) {
        Optional<Student> optional = mongodbDao.findById(student.getId());
        if(optional.isPresent()){
            mongodbDao.save(student);
        }

    }

    @Override
    public void delete(String  id) {
        mongodbDao.deleteById(id);
    }

    @Override
    public Page<Student> findAllByPage(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Student> all = mongodbDao.findAll(pageable);
        return all;
    }

    @Override
    public List<Student> findLikeName(String name) {
        return mongodbDao.findByNameLike(name);
    }
}
