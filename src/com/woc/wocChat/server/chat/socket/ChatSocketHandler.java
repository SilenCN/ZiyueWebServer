package com.woc.wocChat.server.chat.socket;

import com.google.gson.Gson;
import com.woc.wocChat.server.msg.model.Msg;

import java.io.*;
import java.net.Socket;

/**
 * Created by silen on 16-10-13.
 */
public class ChatSocketHandler implements Runnable {

    private Socket client;

    public ChatSocketHandler(Socket client) {
        this.client = client;
        new Thread(this).start();
    }

    public void run() {
        try {
            //获取Socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                //接收从客户端发送过来的数据
                String str = buf.readLine();
                if (str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        Msg msg= new Gson().fromJson(str,Msg.class);

                    }
                }
            }
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}