package com.dyj.dim.mina.handler;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.litesuits.android.log.Log;
import com.litesuits.common.assist.Check;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import static com.dyj.dim.mina.config.BaseConfig.DIM;

/**
 * Created by DYJ.
 * 日期：2016/12/11.
 * 描述：用于处理消息的Handler
 * 備注：
 */

public class DIMMinaHandler extends IoHandlerAdapter {

    private Context mContext;
    public static final String MESSAGE = "message";
    private static final String BROADCAST_MESSAGE_ACTION = "com.dyj.dim.nima.message";

    public DIMMinaHandler(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        String info = "连接打开...,返回给服务器的response";
        session.write(info);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Log.e(DIM, "收到消息...." + message.toString());
        if (Check.isNull(mContext)) {
            Intent intent = new Intent(BROADCAST_MESSAGE_ACTION);
            intent.putExtra(MESSAGE, message.toString());
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
        }
    }
}
