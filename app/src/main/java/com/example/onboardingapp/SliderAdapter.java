package com.example.onboardingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int[] slide_images ={
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12
    };

    public String[] slide_heading = {
            "EAT",
            "SLEEP",
            "CODING"
    };

    public String[] slide_description = {
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.ivslide);
        TextView textHeading = (TextView) view.findViewById(R.id.tvHeader);
        TextView textDescription = (TextView) view.findViewById(R.id.tvContent);

        slideImageView.setImageResource(slide_images[position]);
        textHeading.setText(slide_heading[position]);
        textDescription.setText(slide_description[position]);

        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
