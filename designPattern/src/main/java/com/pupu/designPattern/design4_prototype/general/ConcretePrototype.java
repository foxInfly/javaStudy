package com.pupu.designPattern.design4_prototype.general;

import lombok.Data;

/**
 * Created by Tom.
 */
@Data
public class ConcretePrototype implements IPrototype {

    private int age;
    private String name;


    @Override
    public ConcretePrototype clone() {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        return concretePrototype;
    }

}
