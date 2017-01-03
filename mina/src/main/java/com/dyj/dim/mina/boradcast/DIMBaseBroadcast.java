package com.dyj.dim.mina.boradcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dyj.dim.mina.handler.DIMMinaHandler;

import static com.dyj.dim.mina.config.BaseConfig.DIM;

/**
 * Created by DYJ.
 * 日期：2016/12/11.
 * 描述：
 * 备注：
 */

public class DIMBaseBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(DIM, "服务器返回的数据：" + intent.getStringExtra(DIMMinaHandler.MESSAGE));

    }

}
