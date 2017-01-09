package com.dyj.dim.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyj.dim.base.fragment.BaseFragment;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 备注：
 */

public class SplashItemFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView == null) {
            int resId = getArguments().getInt("resId", 0);
            if (resId != 0) {
                contentView = inflater.inflate(resId, null);
            }
        }
        return contentView;
    }

    public static SplashItemFragment newInstance(int resId) {
        Bundle args = new Bundle();
        args.putInt("resId", resId);
        SplashItemFragment fragment = new SplashItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
