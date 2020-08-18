package com.pupu.processAndThread.n2;


import com.pupu.constant.Constants;
import lombok.extern.slf4j.Slf4j;

/**异步不等待
 * @author : lipu
 * @since : 2020-03-05 12:03
 */
@Slf4j(topic = "c.Async")
public class Async {
    public static void main(String[] args) {
        new Thread(()-> com.pupu.processAndThread.util.FileReader.read(Constants.MP4_FULL_PATH)).start();
        log.info("Async do other things...");
    }
}
