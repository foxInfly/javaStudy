package com.pupu.dao.impl;

import com.pupu.dao.AccountDao;

import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-07 20:31
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public List findAll() {
        System.out.println("列表查询成功");
        return null;
    }
}
