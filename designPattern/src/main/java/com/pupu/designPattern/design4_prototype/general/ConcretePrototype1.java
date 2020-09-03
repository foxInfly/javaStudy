package com.pupu.designPattern.design4_prototype.general;

import lombok.Data;

import java.util.List;

/**
 * clone是浅克隆
 */
@Data
public class ConcretePrototype1 implements Cloneable {

    private int age;
    private String name;
    private List<String> hobies;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
