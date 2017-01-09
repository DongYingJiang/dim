package com.dyj.dim.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.dyj.dim.imageloader.cache.ImageCache;
import com.dyj.dim.imageloader.cache.MemoryCache;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 备注：
 */

public class ImageLoader implements IImageLoader {

    private static ImageLoader imageLoader;

    private ImageCache cache;

    //线程池，数量为处理器数量
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private WeakReference<Context> mContext;

    public ImageLoader(Context context) {
        this.mContext = new WeakReference<>(context);
        setCache(new MemoryCache());
    }

    @Override
    public void display(ImageView imageView, final String url) {
        Bitmap bitmap = cache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    downLoadImg(url);
                }
            });
        }
    }

    private void downLoadImg(String url) {

    }

    public void setCache(ImageCache cache) {
        this.cache = cache;
    }

    public static ImageLoader getInstance(Context context) {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                imageLoader = new ImageLoader(context);
            }
        }
        return imageLoader;
    }

}
