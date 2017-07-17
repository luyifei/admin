package com.admin.base;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.BaseTest;

public class MyComponentTest extends BaseTest{
    @Autowired
    MyComponent myComponent;
    @Test
    public void testgetUser(){
        myComponent.add(1, 2);
    }
}
