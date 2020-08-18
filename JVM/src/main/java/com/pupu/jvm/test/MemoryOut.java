package com.pupu.jvm.test;

import java.util.ArrayList;
import java.util.List;

/**模拟内存溢出
 * @author : lipu
 * @since : 2020-02-23 22:18
 */
public class MemoryOut {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<Demo>();
        while (true){
            list.add(new Demo());
        }
    }
}
