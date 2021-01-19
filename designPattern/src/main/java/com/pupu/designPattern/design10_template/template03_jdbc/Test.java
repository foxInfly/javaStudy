package com.pupu.designPattern.design10_template.template03_jdbc;

import com.pupu.designPattern.design10_template.template03_jdbc.dao.MemberDao;

import java.util.List;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
    }
}
