package com.woc.wocChat.server.user.Service;


import com.woc.wocChat.server.MySQL.SQLBase;

/**
 * Created by 10397 on 2016/6/14.
 */
public class UserService {
    private static final String ADD_USER_SQL = "insert into user(signUpTime,lastLogin) values(%d,%d)";
    private static final String MODIFY_USER_SIGN_SQL ="update user set sign=\"%s\" where id=%d";
    public static boolean addUser(){
        return new SQLBase().executeSQL(String.format(ADD_USER_SQL,new Object[]{(int)System.currentTimeMillis(),(int)System.currentTimeMillis()}));
    }
    public static boolean modifySign(int userId,String sign){
        return new SQLBase().executeSQL(String.format(MODIFY_USER_SIGN_SQL,new Object[]{sign,userId}));
    }

}
