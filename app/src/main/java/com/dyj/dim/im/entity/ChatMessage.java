package com.dyj.dim.im.entity;

import com.dyj.dim.base.message.BaseMessage;

/**
 * Created by DYJ on 2016/12/13.
 */
public class ChatMessage extends BaseMessage {

    public ChatMessage(long time) {
        setMessageTime(time);
    }


}
