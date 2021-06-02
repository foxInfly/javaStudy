package com.pupu.designPattern.design5_adapter.demo.passport;

/**
 * Created by Tom.
 */
public class PassportService {

    /**
     * 注册方法
     * @param username username
     * @param password password
     */
    public ResultMsg regist(String username,String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }

    /**
     * 登录的方法
     * @param username username
     * @param password password
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
