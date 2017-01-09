package com.dyj.dim.imageloader.cache;

import android.graphics.Bitmap;

import java.util.WeakHashMap;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 备注：
 */

public class MemoryCache implements ImageCache {

    private WeakHashMap<String, Bitmap> bitmaps;

    @Override
    public void put(String key, Bitmap bitmap) {
        if (bitmaps == null) {
            bitmaps = new WeakHashMap<>();
        }
        bitmaps.put(key, bitmap);
    }

    @Override
    public Bitmap get(String key) {
        Bitmap bitmap = bitmaps.get(key);
        if (bitmaps == null) {
        }
        return null;
    }
}
