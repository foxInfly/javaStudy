package com.pupu.service.impl;

import com.pupu.service.AccountService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author : lipu
 * @since : 2020-03-09 17:11
 */
@Setter
public class AccountServiceImpl2 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;


    public void findAll() {
        System.out.println("findAll()成功！！name="+name+",age="+age+",birthday="+birthday);
    }

}
