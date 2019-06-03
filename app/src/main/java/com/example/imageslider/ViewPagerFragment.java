package com.example.imageslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class ViewPagerFragment extends Fragment {
    private String[] imgURLs = new String[]
            {"https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/slide3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg",
                    "https://www.vibingticket.com/assets/images/uploads/official_partners/mobile/b-3.jpg"};

    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private String title;
    private int page;

    public static ViewPagerFragment newInstance(int page, String title) {
        ViewPagerFragment fragmentFirst = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        pager = view.findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getActivity(), imgURLs);
        pager.setAdapter(adapter);

        CircleIndicator indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        adapter.registerDataSetObserver(indicator.getDataSetObserver());
        adapter.startAutoScroll(pager);
        return view;
    }
}
