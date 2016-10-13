package com.woc.wocChat.server.msg.handle;

import static com.woc.wocChat.server.msg.MsgConst.MSG_STATUS_OFFLINE;

/**
 * Created by silen on 16-10-13.
 */
public class MsgHandle {
    public static boolean isExit(int status){
        if (MSG_STATUS_OFFLINE==status){
            return true;
        }else{
            return false;
        }
    }

}
