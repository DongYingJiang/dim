package com.dyj.dim.base.message;

/**
 * Created by Administrator on 2016/12/13.
 */
public class BaseMessage {

    public long messageId;

    public long messageTime;

    public int messageType;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
