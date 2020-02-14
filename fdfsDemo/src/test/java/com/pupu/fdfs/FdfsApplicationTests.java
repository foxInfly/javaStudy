package com.pupu.fdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

/**单元测试类
 * @author : lipu
 * @since : 2020-02-14 21:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsApplicationTests {


    //注入fdfs客户端实体类，文件操作接口封装，
    @Autowired
    private FastFileStorageClient client;

    @Test
    public void fileUpload() throws Exception{
        File file = new File("F:\\data\\fdfs测试图片\\1.png");
        String fileName = file.getName();
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = client.uploadFile(inputStream, file.length(), fileName.substring(fileName.lastIndexOf(".") + 1), null);
        System.out.println("storePath.getPath():"+storePath.getPath());
        System.out.println("storePath.getFullPath():"+storePath.getFullPath());
        System.out.println("storePath.getGroup():"+storePath.getGroup());
    }

}
