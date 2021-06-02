package com.pupu.designPattern.design5_adapter.demo.passport.adapterv1;

import com.pupu.designPattern.design5_adapter.demo.passport.ResultMsg;

/**
 * 适配器接口  第三方登录
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone, String code);

}
