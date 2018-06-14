package com.goddess.ioc.example;

import com.goddess.ioc.anno.Component;

/**
 * Created by windlike.xu on 2018/6/14.
 */
@Component(id = "dataAccessInterface")
public class DataAccessInterface {

    public String queryFromTableA() {
        return "query result";
    }
}
