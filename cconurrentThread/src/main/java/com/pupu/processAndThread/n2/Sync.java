package com.pupu.processAndThread.n2;


import com.pupu.constant.Constants;
import com.pupu.processAndThread.util.FileReader;
import lombok.extern.slf4j.Slf4j;


/**同步等待
 * @author : lipu
 * @since : 2020-03-05 12:03
 */
@Slf4j(topic = "c.Sync")
public class Sync {
    public static void main(String[] args) {
        FileReader.read(Constants.MP4_FULL_PATH);
        log.info("Sync do other things...");
    }
}
