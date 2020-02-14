package com.pupu.fdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author : lipu
 * @since : 2020-02-14 19:08
 */
@SpringBootApplication
@Import(FdfsClientConfig.class)  //导入配置文件
public class FdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdfsApplication.class,args);
    }
}
