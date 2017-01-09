package com.dyj.dim.im.fragment;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.dyj.dim.R;
import com.dyj.dim.base.fragment.BaseFragment;

/**
 * Created by DYJ.
 * 日期：2017/1/8.
 * 描述：
 * 備注：
 */

public class TestFragment extends BaseFragment {


    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = inflater.inflate(R.layout.page1, null);
            contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            RatingBar ratingBar = (RatingBar) contentView.findViewById(R.id.rating_bar);
            LayerDrawable drawable = (LayerDrawable) ratingBar.getProgressDrawable();
            drawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

        }
        return contentView;
    }

    public static TestFragment newInstance() {

        Bundle args = new Bundle();

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
