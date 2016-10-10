package com.woc.wocChat.server;

/**
 * Created by silen on 16-10-10.
 */
public class SQLCommand {
    private static final String CREATE_DATEBASE_SQL = "CREATE DATABASE ziyue";
    private static final String CREATE_TABLE_USER_SQL = "CREATE TABLE user(id INTEGER PRIMARY KEY AUTO_INCREMENT,username TEXT,password TEXT,lastLogin BIGINT,signUpTime BIGINT,sign TEXT";
}
