package com.dyj.dim.mina.config;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by DYJ.
 * 日期：2016/12/11.
 * 描述：
 * 備注：
 */

public class ConnectionConfig implements Serializable {

    private Context context;
    private String ip;
    private int port;
    private int readBufferSize;
    private long connectTimeOut;
    private long retryCount;

    public Context getContext() {
        return context;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public int getReadBufferSize() {
        return readBufferSize;
    }

    public long getConnectTimeOut() {
        return connectTimeOut;
    }

    public long getRetryCount() {
        return retryCount;
    }

    public static class Builder {
        private Context context;
        private String ip = "192.168.0.108";   //默认IP地址
        private int port = 62475;  //默认端口号
        private int readBufferSize = 10240;  //  默认1MB的缓存
        private long connectTimeOut = 10000; // 默认10s 的超时时间
        private long retryCount = 5000; //线程断开连接后的轮询连接间隔，5s

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setReadBufferSize(int readBufferSize) {
            this.readBufferSize = readBufferSize;
            return this;
        }

        public Builder setConnectTimeOut(long connectTimeOut) {
            this.connectTimeOut = connectTimeOut;
            return this;
        }

        public Builder setRetryCount(long retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        private void apply(ConnectionConfig config) {
            config.context = this.context;
            config.ip = this.ip;
            config.port = port;
            config.connectTimeOut = this.connectTimeOut;
            config.readBufferSize = this.readBufferSize;
            config.retryCount = this.retryCount;
        }

        public ConnectionConfig create() {
            ConnectionConfig config = new ConnectionConfig();
            apply(config);
            return config;
        }
    }

}
