package com.gp.demo07_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lp
 * @since 2021-01-26 17:34:24
 */
public class Test {

    @org.junit.Test
    public  void test01() {
        List<String> strs = new ArrayList<>();
        strs.add("1");
        strs.add("2");
        strs.add(null);
        strs.add(null);
        strs.add("3");
        System.out.println(strs.size());
    }
}
