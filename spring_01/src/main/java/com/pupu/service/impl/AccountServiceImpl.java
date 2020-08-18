package com.pupu.service.impl;

import com.pupu.service.AccountService;
import lombok.Setter;

import java.util.Date;

/**
 * @author : lipu
 * @since : 2020-03-09 17:11
 */
public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void findAll() {
        System.out.println("findAll()成功！！name="+name+",age="+age+",birthday="+birthday);
    }

}
