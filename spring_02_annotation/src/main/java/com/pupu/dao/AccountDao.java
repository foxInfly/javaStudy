package com.pupu.dao;

import com.pupu.domain.Account;

import java.util.List;

/**
 * @author : lipu
 * @since : 2020-03-10 08:37
 */
public interface AccountDao {


    List<Account> findAll();
}
