package com.pupu.designPattern.design3_builder.sql;

import java.util.Arrays;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andBetween("age",12,23);
        queryRule.andEqual("addr","Changsha");
        queryRule.andLike("name","Tom");
        queryRule.addAscOrder("age");
        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);

        System.out.println(builder.builder("t_member"));

        System.out.println("Params: " + Arrays.toString(builder.getValues()));


    }
}
