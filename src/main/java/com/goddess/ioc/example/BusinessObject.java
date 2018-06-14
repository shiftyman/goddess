package com.goddess.ioc.example;

import com.goddess.ioc.anno.Autowire;
import com.goddess.ioc.anno.Component;

/**
 * Created by windlike.xu on 2018/6/14.
 */
@Component(id="businessObject")
public class BusinessObject {

    @Autowire(id="dataAccessInterface")
    private DataAccessInterface dai;

    public void print() {
        System.out.println(dai.queryFromTableA());
    }

    public void setDai(DataAccessInterface dai) {
        this.dai = dai;
    }
}
