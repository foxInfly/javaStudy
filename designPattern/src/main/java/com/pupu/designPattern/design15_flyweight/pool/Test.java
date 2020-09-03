package com.pupu.designPattern.design15_flyweight.pool;

import java.sql.Connection;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection conn = pool.getConnection();
        System.out.println(conn);
    }
}
