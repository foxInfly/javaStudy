package com.pupu.jvm.java;


import com.sun.net.ssl.internal.ssl.Provider;
import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;

/**测试类加载器1
 * @author : lipu
 * @since : 2020-03-02 10:59
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*********启动类加载器********");
        //获取bootClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        //从上面的路径中随意选一个类，看看它的类加载器是什么
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);//null

        System.out.println("*********扩展类加载器********");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@60e53b93
    }
}
