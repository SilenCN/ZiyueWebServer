package com.woc.wocChat.server.MySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.woc.wocChat.SQLInit.*;

/**
 * Created by 10397 on 2016/6/13.
 */
public class SQLBase {
    private String DatabaseUrl = "jdbc:mysql://" + DatabaseServer + ":" + DatabasePort + "/" + DatabaseName;
    private static Connection conn;

    public SQLBase() {
        System.out.println("SQL connection is null?"+conn == null);
        if (null == conn) {
            try {
                Class.forName(DatabaseDriver);
                conn = DriverManager.getConnection(DatabaseUrl, DatabaseUser, DatabasePW);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public List<Map<String, Object>> queryDataWithReturn(String command) {
        String commandChecked = checkSqlCommand(command);
        List list = new ArrayList();


        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(commandChecked);
            if (!resultSet.wasNull()) {
                while (resultSet.next()) {
                    list.add(convertMap(resultSet));
                }
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public Boolean executeSQL(String command) {
        String commandChecked = checkSqlCommand(command);
        System.out.println(commandChecked);
        try {
            Statement statement = conn.createStatement();
            return !statement.execute(commandChecked);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String checkSqlCommand(String command) {
        String returnString;
        //检查

        returnString = command;

        return returnString;
    }

    public static Map<String, Object> convertMap(ResultSet rs) {
        Map<String, Object> map = new TreeMap<String, Object>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                map.put(md.getColumnName(i), rs.getObject(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return map;
        }
    }
}
