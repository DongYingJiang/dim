package com.dyj.dim.utils;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 备注：
 */
public interface ISharedPreference {

    void putInt(String key, int value);

    void getInt(String key, int defaultValue);

    void putString(String key, String value);

    void getString(String key);
}
