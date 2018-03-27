package com.example.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * Created by huqifeng on 2018/02/09 12:05.
 */
public class demo1 {
    public static void main(String[] args) {
        String path = "classpath:shiro.ini";
        // 获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(path);
        // 获取SecurityManager 并赋给 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 获取token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang","123");

        try{
            subject.login(token);
            System.out.println("登陆成功！");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("用户名或密码错误！");
        }


        subject.logout();

    }

}
