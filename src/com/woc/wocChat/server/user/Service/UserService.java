package com.woc.wocChat.server.user.Service;


import com.sun.javafx.collections.MappingChange;
import com.woc.wocChat.server.MySQL.SQLBase;
import com.woc.wocChat.server.user.model.User;

import java.util.Map;

/**
 * Created by 10397 on 2016/6/14.
 */
public class UserService {
    private static final String ADD_USER_SQL = "insert into user(signUpTime,lastLogin) values(%ld,%ld)";
    private static final String MODIFY_USER_SIGN_SQL ="update user set sign=\"%s\" where id=%d";
    private static final String GET_USER_INFO_BY_ID_SQL = "select * from user where id=%d";
    private static final String GET_USER_SIGN_BY_ID_SQL = "select sign from user where id=%d";
    public static boolean addUser(){
        return new SQLBase().executeSQL(String.format(ADD_USER_SQL,new Object[]{System.currentTimeMillis(),System.currentTimeMillis()}));
    }
    public static boolean modifySign(int userId,String sign){
        return new SQLBase().executeSQL(String.format(MODIFY_USER_SIGN_SQL,new Object[]{sign,userId}));
    }

    public static Map<String,Object> getUserInfo(int userId){
        return new SQLBase().queryDataWithReturn(String.format(GET_USER_INFO_BY_ID_SQL,new Object[]{userId})).get(0);
    }
    public static String getUserSign(int userId){
        return (String) ((new SQLBase()).queryDataWithReturn(String.format(GET_USER_SIGN_BY_ID_SQL,new Object[]{userId})).get(0).get("sign"));
    }

}
