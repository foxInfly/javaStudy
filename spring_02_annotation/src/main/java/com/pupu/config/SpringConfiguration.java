package com.pupu.config;

import org.springframework.context.annotation.*;

/**该类是一个配置类，它的作用和bean.xml一样
 * 注解是：
 *      Configuration:指定是注解类
 *          细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，这个注解可以不写，
 *          如果不作为参数，一定要写
 *      ComponentScan：指定扫描的包
 *             属性：value和basePackage的作用是一样的，指定扫描的包
 *      Bean：把方法的返回值作为bean对象存入到容器中(默认单例)
 *             属性：name（指定bean的id，不写默认是当前方法名称）
 *      Import:导入其他的配置类,被动如的配置类可以不用加Configuration注解了
 *      PropertySource:读入配置文件;classpath:指定是类路径下的
 *              属性：value指定配置文件的名称路径
 * @author : lipu
 * @since : 2020-03-10 09:12
 */
@Configuration
@ComponentScan(basePackages = "com.pupu")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
