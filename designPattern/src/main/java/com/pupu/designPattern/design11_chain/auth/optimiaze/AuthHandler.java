package com.pupu.designPattern.design11_chain.auth.optimiaze;

import com.pupu.designPattern.design11_chain.auth.Member;

/**
 * Created by Tom.
 */
public class AuthHandler extends Handler {
    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }
}
