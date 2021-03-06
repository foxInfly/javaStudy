package com.pupu.dao;

import com.pupu.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**用户持久层接口
 * @author : lipu
 * @since : 2020-03-09 10:50
 */
public interface UserDao {

    /**
     * 查询所有用户
    */
    @Select("select * from USER")
    List<User> findAll();
}
