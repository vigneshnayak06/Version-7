package com.example.hp.navigationdraw;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivityIntro extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    Button next,skip;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    private ViewPager viewPager;
    private IntroManager introManager;
    private int[] layouts=new int[]{R.layout.activity_screen_1,R.layout.activity_screen_2,
            R.layout.activity_screen_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        introManager=new IntroManager(this);
        if(!introManager.check())
        {
            introManager.setFirst(false);
            Intent i=new Intent(MainActivityIntro.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        setContentView(R.layout.activity_main_intro);

        viewPager=(ViewPager)findViewById(R.id.view_pager);
        skip=(Button)findViewById(R.id.skip);
        next=(Button)findViewById(R.id.nxt);

        viewPagerAdapter=new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(vl);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivityIntro.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current=getItem(+1);
                if (current<layouts.length){
                    viewPager.setCurrentItem(current);
                }
                else{
                    Intent i=new Intent(MainActivityIntro.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

    ViewPager.OnPageChangeListener vl=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i==layouts.length-1){
                skip.setText("Proceed");
                next.setVisibility(View.GONE);
            }
            else{
                next.setText("Next");
                skip.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void changeStatusBar(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater li;

        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            li=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=li.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View v=(View)object;
            container.removeView(v);
        }
    }

}
