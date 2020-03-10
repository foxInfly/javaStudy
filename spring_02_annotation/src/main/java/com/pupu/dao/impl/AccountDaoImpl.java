package com.pupu.dao.impl;

import com.pupu.dao.AccountDao;
import com.pupu.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-10 08:38
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Resource
    private QueryRunner runner;

    @Override
    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            accounts = runner.query("select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
