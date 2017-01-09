package com.dyj.dim.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：SharedPreferences 工具类 ，用于方便存储SharedPreferences数据
 * 备注：
 */

public class SharedPreferenceUtil implements ISharedPreference {

    private final String DEFAULT_SP_INFO = "dim_sp_default_info";

    private Context mContext;
    private SharedPreferences mSharedPreferences;

    public SharedPreferenceUtil(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(DEFAULT_SP_INFO, mContext.MODE_PRIVATE);
    }

    public void setXmlFileName(String fileName) {

    }

    public static SharedPreferenceUtil newInstance(Context context) {
        SharedPreferenceUtil fragment = new SharedPreferenceUtil(context);
        return fragment;
    }

    @Override
    public void getString(String key) {

    }

    @Override
    public void putInt(String key, int value) {

    }

    @Override
    public void getInt(String key, int defaultValue) {

    }

    @Override
    public void putString(String key, String value) {

    }
}
