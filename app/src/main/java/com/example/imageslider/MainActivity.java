package com.example.imageslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String[] imgURLs = new String[]
            {"https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/slide3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg"};

    private ViewPager pager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        pager = findViewById(R.id.viewPager);
//        adapter = new ViewPagerAdapter(this, imgURLs);
//        pager.setAdapter(adapter);
//
//        CircleIndicator indicator = findViewById(R.id.indicator);
//        indicator.setViewPager(pager);
//
//        adapter.registerDataSetObserver(indicator.getDataSetObserver());

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (pager != null){
//            adapter.startAutoScroll(pager);
//        }

    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (pager != null){
//            adapter.stopAutoScroll();
//        }
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ViewPagerFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FirstFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FirstFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}
