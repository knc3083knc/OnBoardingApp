package com.example.onboardingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout layoutDot;

    TextView[] mDots;

    SliderAdapter sliderAdapter;

    Button btnBack;
    Button btnNext;

    int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        layoutDot = (LinearLayout) findViewById(R.id.dotLayout);

        btnBack = (Button) findViewById(R.id.backBtn);
        btnNext = (Button) findViewById(R.id.nextBtn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotaIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage-1);

            }
        });
    }

    public void addDotaIndicator(int position)
    {
        mDots = new TextView[sliderAdapter.slide_images.length];
        layoutDot.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTranparentWhite));
            layoutDot.addView(mDots[i]);
        }
        if(mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotaIndicator(i);
            mCurrentPage = i;

            if(i==0)
            {
                btnNext.setEnabled(true);
                btnBack.setEnabled(false);
                btnBack.setVisibility(View.INVISIBLE);

                btnNext.setText("NEXT");
                btnBack.setText("");
            }
            else if(i==mDots.length-1)
            {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("FINISH");
                btnBack.setText("BACK");
            }
            else
            {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("NEXT");
                btnBack.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
