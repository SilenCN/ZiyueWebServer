package com.woc.wocChat.server.chat.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by silen on 16-10-13.
 */
public class ChatServer {
    public static final int PORT = 65521;//监听的端口号

    public ChatServer() {
        init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                new ChatSocketHandler(serverSocket.accept());
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }


}
