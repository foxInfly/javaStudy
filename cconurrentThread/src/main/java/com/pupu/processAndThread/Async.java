package com.pupu.processAndThread;


import com.pupu.constant.Constants;
import lombok.extern.slf4j.Slf4j;

/**异步不等待
 * @author : lipu
 * @since : 2020-03-05 12:03
 */
@Slf4j
public class Async {
    public static void main(String[] args) {
        new Thread(()-> com.pupu.processAndThread.util.FileReader.read(Constants.MP4_FULL_PATH)).start();
        log.debug("Async do other things...");
    }
}
