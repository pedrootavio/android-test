package com.example.pedro.teste.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.pedro.teste.R;

import java.util.Arrays;
import java.util.List;

public class TabScrollActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_scroll);

        scrollView = findViewById(R.id.scrollView);
        tabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        List<String> tabTitles = Arrays.asList("Page 1");

        viewPager.setAdapter(new TabAdapter(this, tabTitles));

        viewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });



    }

    private class TabAdapter extends PagerAdapter {

        private Context context;
        private List<String> tab;

        public TabAdapter(Context context, List<String> tab) {
            this.context = context;
            this.tab = tab;
        }

        @Override
        public int getCount() {
            return tab.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.content_tab_test_page_1, null);

            ViewPager viewPager = (ViewPager) container;
            viewPager.addView(view, 0);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager viewPager = (ViewPager) container;
            View view = (View) object;
            viewPager.removeView(view);
        }
    }
}
