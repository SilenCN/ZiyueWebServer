package com.woc.wocChat.server.msg.handle;

import com.woc.wocChat.server.chat.socket.ChatSocketHandler;
import com.woc.wocChat.server.msg.model.Msg;
import com.woc.wocChat.server.queue.WaitQueue;
import com.woc.wocChat.server.user.Service.UserService;
import com.woc.wocChat.server.user.model.User;

import static com.woc.wocChat.server.msg.MsgConst.MSG_STATUS_LOGIN;
import static com.woc.wocChat.server.msg.MsgConst.MSG_STATUS_OFFLINE;
import static com.woc.wocChat.server.msg.MsgConst.MSG_STATUS_TYPE_SYSTEMMSG;

/**
 * Created by silen on 16-10-13.
 */
public class MsgHandle {

    public static boolean handle(Msg msg, ChatSocketHandler chatSocketHandler){
        if (MSG_STATUS_TYPE_SYSTEMMSG==msg.getType()){
            switch (msg.getType()){
                case MSG_STATUS_OFFLINE:chatSocketHandler.chatExit();break;
                case MSG_STATUS_LOGIN:int userId=Integer.parseInt(msg.getContent());
                    User user=new User();
                    user.setId(userId);
                    user.setSign(UserService.getUserSign(userId));
                    chatSocketHandler.setUser(user);
                    chatSocketHandler.sendMsgToClient(createMsg(MSG_STATUS_TYPE_SYSTEMMSG,MSG_STATUS_LOGIN,"true"));
                    WaitQueue.add(chatSocketHandler);
                    break;
            }
        }else {
            chatSocketHandler.sendMsgToPartner(msg);
        }
        return true;
    }

    public static Msg createMsg(int type,int status,String content){
        Msg msg=new Msg();
        msg.setType(type);
        msg.setStatus(status);
        msg.setContent(content);
        msg.setTime(System.currentTimeMillis());
        return msg;
    }

}
