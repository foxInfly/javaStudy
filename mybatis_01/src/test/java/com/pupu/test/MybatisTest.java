package com.pupu.test;

import com.pupu.dao.UserDao;
import com.pupu.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-09 11:16
 */
@Slf4j(topic = "c")
public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        log.debug("init()执行完毕");
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        session.commit();

        session.close();
        in.close();
        log.debug("destroy()执行完毕");
    }
    @Test
    public void testFindAll() {
        //1.读取配置文件
        //2.创建SqlSessionFactory工厂
        //3.使用工厂生产SqlSession对象
        //4.使用SqlSession创建Dao接口的代理对象
        //5.使用代理对象执行方法
        //6.释放资源

        userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //新增
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("普 mybatis last insert id");
        user.setAddress("合肥");
        user.setSex("男");
        user.setBirthday(new Date());
        log.debug("保存用户前的数据：{}",user);
        userDao = session.getMapper(UserDao.class);
        userDao.saveUser(user);

        log.debug("保存用户成功，用户数据：{}",user);
    }
    //更新
    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(5);
        user.setUsername("琼");
        user.setAddress("合肥");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao = session.getMapper(UserDao.class);
        userDao.updateUser(user);

        log.debug("修改用户成功！！");
    }

    //删除
    @Test
    public void testDeleteById() {
        Integer id =2;
        userDao = session.getMapper(UserDao.class);
        userDao.deleteUser(id);
        log.debug("删除用户成功！！");
    }

    @Test
    public void testFindById(){
        Integer id =5;
        userDao = session.getMapper(UserDao.class);
        User user = userDao.findUserById(id);
        log.debug("查询用户成功：{}",user);
    }
    //模糊查询
    @Test
    public void testFindLikeName(){
//        String name ="%普%";
        String name ="普";
        userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findUserLikeName(name);
        log.debug("模糊查询用户成功：{}",users);
    }

    @Test
    public void testFindTotal(){
        userDao = session.getMapper(UserDao.class);
        Integer count= userDao.findUserCount();
        log.debug("用户总数：{}",count);
    }

}
