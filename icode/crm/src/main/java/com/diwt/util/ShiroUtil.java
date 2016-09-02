package com.diwt.util;

import com.diwt.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    /**
     * 查询当前登录者信息
     * @return ShiroUser
     */
    public static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getCurrentUserID(){
        return getCurrentUser().getId();
    }
    public static String getCurrentUserName(){
        return getCurrentUser().getUsername();
    }

    public static String getCurrentTel() {
        return  getCurrentUser().getTel();
    }

    /**
     * 判断当前是否登录状态
     * @return
     */
    public static boolean isCurrentUser(){
        return getCurrentUser() != null;
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 判断当前用户是否是管理员
     * @return
     */
    public static boolean isAdmin () {
        return getSubject().hasRole("管理员");
    }

    /**
     * 判断当前用户是否是经理
     * @return
     */
    public static boolean isManager() {
        return getSubject().hasRole("经理");
    }

    /**
     * 判断当前用户是否是普通员工
     * @return
     */
    public static boolean isEmployee() {
        return getSubject().hasRole("员工");
    }


}
