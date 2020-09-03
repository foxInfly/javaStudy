package com.pupu.designPattern.design5_adapter.demo.passport.adapterv2.adapters;

import com.pupu.designPattern.design5_adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTelAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }

}
