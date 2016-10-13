package com.woc.wocChat.server.queue;

import com.woc.wocChat.server.chat.socket.ChatSocketHandler;

import java.util.LinkedList;

/**
 * Created by 10397 on 2016/10/13.
 */
public class WaitQueue {
    public static LinkedList<ChatSocketHandler> queue = new LinkedList<>();

    public static void add(ChatSocketHandler chatSocketHandler) {
        if (null != chatSocketHandler) {
            queue.add(chatSocketHandler);
            if (queue.size()>1){
                matchPartner();
            }
        }
    }

    private static void matchPartner(){
        queue.get(0).setPartnerSocket(queue.get(1));
        queue.get(1).setPartnerSocket(queue.get(0));
        queue.remove(0);
        queue.remove(0);
    }
}
