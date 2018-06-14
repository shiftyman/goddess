package com.goddess.ioc.example;

import com.goddess.ioc.BeanFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by windlike.xu on 2018/6/14.
 */
public class BeanFactoryTester {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BeanFactory beanFactory = new BeanFactory("com.goddess.ioc.example");

        BusinessObject obj = (BusinessObject) beanFactory.getBean("businessObject");
        obj.print();

    }

}
