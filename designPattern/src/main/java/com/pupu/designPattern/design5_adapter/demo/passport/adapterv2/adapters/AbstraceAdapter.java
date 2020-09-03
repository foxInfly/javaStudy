package com.pupu.designPattern.design5_adapter.demo.passport.adapterv2.adapters;

import com.pupu.designPattern.design5_adapter.demo.passport.PassportService;
import com.pupu.designPattern.design5_adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public abstract class AbstraceAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
