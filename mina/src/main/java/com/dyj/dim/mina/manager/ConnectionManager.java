package com.dyj.dim.mina.manager;

import android.content.Context;

import com.dyj.dim.mina.config.ConnectionConfig;
import com.dyj.dim.mina.handler.DIMMinaHandler;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;

/**
 * Created by DYJ.
 * 日期：2016/12/11.
 * 描述：用于管理客户端与服务器连接的管理类
 * 備注：
 */

public class ConnectionManager {

    private ConnectionConfig mConfig;
    private WeakReference<Context> mContext;
    private NioSocketConnector mConnection;
    private IoSession mSession;
    private InetSocketAddress mAddress;

    public ConnectionManager(ConnectionConfig config) {
        this.mConfig = config;
        mContext = new WeakReference<Context>(config.getContext());
        init();
    }

    /**
     * 内部初始化方法
     */
    private void init() {
        mAddress = new InetSocketAddress(mConfig.getIp(), mConfig.getPort());
        mConnection = new NioSocketConnector();
        mConnection.getSessionConfig().setReadBufferSize(mConfig.getReadBufferSize());
        mConnection.getFilterChain().addLast("logging", new LoggingFilter());
        mConnection.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        mConnection.setHandler(new DIMMinaHandler(mContext.get()));
        mConnection.setDefaultRemoteAddress(mAddress);
    }

    /**
     * 与服务进行连接
     *
     * @return 是否连接成功
     */
    public boolean connect() {
        try {
            ConnectFuture future = mConnection.connect();
            future.awaitUninterruptibly();
            mSession = future.getSession();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return mSession != null;
    }


    /**
     * 断开与服务器的连接
     */
    public void disConnection() {
        mConnection.dispose();
        mConnection = null;
        mSession = null;
        mContext = null;
    }

}
