package com.pupu.processAndThread.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**文件全路径读取util
 * @author : lipu
 * @since : 2020-03-05 12:10
 */
@Slf4j(topic = "pupu")
public class FileReader {

    /** 根据文件名读取文件
     * @author lipu
     * @since  2020/3/5 12:24
     * @param  filePath 文件名
    */
    public static void read(String filePath){
        int idx = filePath.lastIndexOf(File.separator);
        try(FileInputStream in = new FileInputStream(filePath)) {
            String shortName = filePath.substring(idx + 1);
            long start = System.currentTimeMillis();
            log.debug("read [{}] start ...", shortName);
            byte[] buf = new byte[1024];
            int n = -1;
            do {
                n = in.read(buf);
            }while (n != -1);
            long end = System.currentTimeMillis();
            log.debug("read [{}] end ... cost: {} ms",shortName,end-start);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
