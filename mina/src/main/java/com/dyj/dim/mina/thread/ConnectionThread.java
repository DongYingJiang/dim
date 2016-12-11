package com.dyj.dim.mina.thread;

import android.os.HandlerThread;

import com.dyj.dim.mina.config.ConnectionConfig;
import com.dyj.dim.mina.manager.ConnectionManager;

/**
 * Created by DYJ.
 * 日期：2016/12/11.
 * 描述：用于使用ConnectionManager类来与服务器的连接
 * 備注：这里才是与服务器连接的入口
 */

public class ConnectionThread extends HandlerThread {

    private boolean isConnection;
    private ConnectionManager manager;
    private ConnectionConfig config;

    public ConnectionThread(String name, ConnectionConfig config) {
        super(name);
        this.config = config;
        manager = new ConnectionManager(config);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        for (; ; ) {
            isConnection = manager.connect();
            if (isConnection) {
                break;
            }
            try {
                Thread.sleep(config.getRetryCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void disConnection() {
        if (manager != null) {
            manager.disConnection();
        }
    }

}
