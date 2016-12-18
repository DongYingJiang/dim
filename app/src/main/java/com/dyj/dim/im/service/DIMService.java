package com.dyj.dim.im.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.dyj.dim.mina.config.ConnectionConfig;
import com.dyj.dim.mina.thread.ConnectionThread;
import com.litesuits.android.log.Log;

import static com.dyj.dim.mina.config.BaseConfig.DIM;

public class DIMService extends Service {

    public static final String IP_KEY = "ip";
    public static final String PORT_KEY = "port";
    public static final String DATA = "data";

    private ConnectionThread thread;

    public DIMService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e(DIM, "服务已创建，正在等待连接到服务器");
        Bundle bundle = intent.getBundleExtra(DATA);
        int port = bundle.getInt(PORT_KEY, -1);
        String ip = bundle.getString(IP_KEY);
        if (port == -1) {
            Log.e(DIM, "port 不存在");
            return super.onStartCommand(intent, flags, startId);
        }
        ConnectionConfig.Builder configBuilder = new ConnectionConfig.Builder(this);
        ConnectionConfig config = configBuilder.setPort(port).setIp(ip).create();
        thread = new ConnectionThread("connection", config);
        thread.start();
        return super.onStartCommand(intent, flags, startId);

    }
}
