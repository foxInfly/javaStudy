package com.pupu.service.impl;

import com.pupu.dao.AccountDao;
import com.pupu.domain.Account;
import com.pupu.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-09 17:11
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;


    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
