package com.pupu.designPattern.design13_observer.observer03_gper;

import lombok.Data;

/**事件内容封装类
 * Created by Tom.
 */
@Data
public class Question {
    /**提问题的用户名*/
    private String userName;
    /**提的题内容*/
    private String content;

}
