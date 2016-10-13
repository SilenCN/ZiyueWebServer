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
    private static ServerSocket serverSocket;
    public ChatServer() {
        init();
    }

    public void init() {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                new ChatSocketHandler(serverSocket.accept());
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }


}
