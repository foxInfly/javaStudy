package com.pupu.designPattern.design11_chain.auth.optimiaze;

import com.pupu.designPattern.design11_chain.auth.Member;

/**
 * Created by Tom.
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
