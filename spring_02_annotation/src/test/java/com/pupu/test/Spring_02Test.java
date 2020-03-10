package com.pupu.test;

import com.pupu.config.SpringConfiguration;
import com.pupu.domain.Account;
import com.pupu.service.AccountService;
import com.pupu.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-09 17:12
 *
 * Spring整合junit
 *      注解RunWith：把袁永德mian替换成spring提供的
 *      注解ContextConfiguration:告知spring和IOC是继续xml还是注解配置的
 *             属性：location，指定xml文件的地址，加上classpath关键字，表示在类路径下
 *             classes：制定提供注解配置类所在位置
 *      当使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Spring_02Test {
    @Resource(name = "accountServiceImpl")
    private  AccountService accountService;
    @Test
    public  void testFindAll() {
        //1.获取容器
        //2.根据id获取对象
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //后面class可以是接口也可是实现类的
//        AccountService accountService = acp.getBean("accountServiceImpl", AccountServiceImpl.class);
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
