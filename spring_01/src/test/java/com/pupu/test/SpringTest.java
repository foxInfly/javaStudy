package com.pupu.test;

import com.pupu.service.AccountService;
import com.pupu.service.impl.AccountServiceImpl;
import com.pupu.service.impl.AccountServiceImpl2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : lipu
 * @since : 2020-03-09 17:12
 */
public class SpringTest {
    public static void main(String[] args) {
        //1.获取容器
        //2.根据id获取对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //后面class可以是接口也可是实现类的
        AccountService accountService = ac.getBean("accountService2", AccountServiceImpl2.class);
        accountService.findAll();
    }
}
