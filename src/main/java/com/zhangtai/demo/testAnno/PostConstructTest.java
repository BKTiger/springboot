package com.zhangtai.demo.testAnno;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @author zhangtai
 * @date 2020/9/14 15:16
 * @Description:
 */
@Component
public class PostConstructTest {

  private String  name;

  @PostConstruct
  public void setName(){
    this.name = "234234";
  }

}
