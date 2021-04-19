package com.bktiger;

import com.bktiger.annotation.TestAnnotation;

@TestAnnotation
public class MyAnnotationBean {

    public MyAnnotationBean(){
        System.out.println("MyAnnotationBean init");
    }
}
