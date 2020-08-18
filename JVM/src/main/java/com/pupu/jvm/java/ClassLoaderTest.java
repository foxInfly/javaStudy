package com.pupu.jvm.java;


/**测试类加载器
 * @author : lipu
 * @since : 2020-03-02 10:59
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层，扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@45ee12a7

        //获取其上层，扩展类加载器
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println(bootClassLoader);//null

        //***获取加载当前类的类加载器：对于用户自定义的类，默认使用系统类加载器来加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //***获取系统API的类加载器：对于核心类库的类，默认使用引导类加载器来加载
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);//null
    }
}
