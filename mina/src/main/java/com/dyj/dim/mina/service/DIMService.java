package com.dyj.dim.mina.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.dyj.dim.mina.config.ConnectionConfig;
import com.dyj.dim.mina.thread.ConnectionThread;
import com.litesuits.android.log.Log;

import static com.dyj.dim.mina.config.BaseConfig.DIM;

public class DIMService extends Service {

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
        Log.e(DIM, "服务已创建，正在等待连接到服务器");
        thread = new ConnectionThread("connection", new ConnectionConfig.Builder(this).create());
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }
}
