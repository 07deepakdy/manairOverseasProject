package com.manairoverseas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.manairoverseas.R;


import java.util.ArrayList;

public class SliderPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Integer> image_arraylist;

    public SliderPagerAdapter(Context context, ArrayList<Integer> image_arraylist) {
        this.context = context;
        this.image_arraylist = image_arraylist;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_slider,container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.im_slider);
        im_slider.setImageResource(image_arraylist.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {

        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
