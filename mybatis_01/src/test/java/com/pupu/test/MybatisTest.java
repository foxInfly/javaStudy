package com.pupu.test;

import com.pupu.dao.UserDao;
import com.pupu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-09 11:16
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        //2.创建SqlSessionFactory工厂
        //3.使用工厂生产SqlSession对象
        //4.使用SqlSession创建Dao接口的代理对象
        //5.使用代理对象执行方法
        //6.释放资源

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
