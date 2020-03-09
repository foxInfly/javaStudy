package com.pupu.dao;

import com.pupu.domain.User;

import java.util.List;

/**用户持久层接口
 * @author : lipu
 * @since : 2020-03-09 10:50
 */
public interface UserDao {

    /**
     * 查询所有用户
    */
    List<User> findAll();

    /**
     * 保存用户
     */
   void saveUser(User user);

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(Integer userId);

    /**
     * 查询户
     */
    User findUserById(Integer userId);

    /**
     * 模糊查询户
     */
    List<User> findUserLikeName(String userName);

    /**
     * 查询总数
     */
    int findUserCount();
}
