package com.example.foodyghar.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodyghar.Adapter.SliderAdapter1;
import com.example.foodyghar.Adapter.viewpageadapter;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.GetImage;
import com.example.foodyghar.Model.GetImage__1;
import com.example.foodyghar.R;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Hotel_detail_fragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    SliderView sliderView;
    ArrayList<GetImage__1> getImage__1s;
    View v;
    private int[] tabIcons = {
            R.drawable.tab_home,
            R.drawable.tab_menu,
            R.drawable.tab_reviews,
            R.drawable.tab_photos,
            R.drawable.ic_baseline_shopping_cart_24,
            R.drawable.tab_about};

    Homepage homepage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_hotel_details, null);
        homepage = (Homepage) getActivity();
        Homepage.toolbar.setVisibility(View.GONE);
        setHasOptionsMenu(false);
        tabLayout = v.findViewById(R.id.tablayout);
        viewPager = v.findViewById(R.id.pager);
        sliderView = v.findViewById(R.id.image_slider);
        viewpageadapter vpd = new viewpageadapter(getFragmentManager());
        vpd.addFragment(new Tab_Home(), "Home");
        vpd.addFragment(new Tab_Menu(), "Menu");
        vpd.addFragment(new Tab_Reviews(), "Reviews");
        vpd.addFragment(new Tab_Photos(), "Photos");
        vpd.addFragment(new Tab_myorder(), "MY Order");
        vpd.addFragment(new Tab_About(), "About");
        viewPager.setAdapter(vpd);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        Tab_Reviews tab_reviews = new Tab_Reviews();


        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String hotel_id = sharedPreferences.getString("hotel_id", null);
        Log.e("HOTEL_ID", hotel_id);
        Call<GetImage> getImageCall = apInterface.getSliderImage(hotel_id);
        getImageCall.enqueue(new Callback<GetImage>() {
            @Override
            public void onResponse(Call<GetImage> call, Response<GetImage> response) {
                try {
                    getImage__1s = (ArrayList<GetImage__1>) response.body().getGetImages();
                    SliderAdapter1 sliderAdapter1 = new SliderAdapter1(getActivity(), getImage__1s);
                    sliderView.setSliderAdapter(sliderAdapter1);

                } catch (Exception e) {

                    Toast.makeText(homepage, "Slider Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetImage> call, Throwable t) {
                Toast.makeText(homepage, "Slider Error", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(5).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}