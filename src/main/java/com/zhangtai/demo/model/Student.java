package com.zhangtai.demo.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zhangtai
 * @date 2018/12/2 14:19
 * @Description:
 */
@Data
@ToString
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private String birthday;
    private String sex;
}
