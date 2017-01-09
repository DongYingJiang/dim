package com.dyj.dim.imageloader.cache;

import android.graphics.Bitmap;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 备注：
 */

public interface ImageCache {

    void put(String key, Bitmap bitmap);

    Bitmap get(String key);

}
