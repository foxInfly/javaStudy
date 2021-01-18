package com.pupu.designPattern.design4_prototype.prototype01_demo;

import java.lang.reflect.Field;

/**
 * Created by Tom.
 */
public class BeanUtils {

    //利用反射clone,是浅克隆
    public static Object copy(Object protorype) {
        Class clazz = protorype.getClass();
        Object returnValue = null;
        try {
            returnValue = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(returnValue, field.get(protorype));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
