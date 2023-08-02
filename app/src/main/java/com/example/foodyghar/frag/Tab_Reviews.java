package com.example.foodyghar.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodyghar.Adapter.Review_adapter;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.Restaurantreview;
import com.example.foodyghar.Model.ResultRestaurantreview;
import com.example.foodyghar.R;
import com.example.foodyghar.RateUsDialog;
import com.example.foodyghar.Rate_us_restaurant;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_Reviews extends Fragment {
    RecyclerView rev_recycler;
    Review_adapter review_adapter;
    Homepage homepage;
    public static TextView review_btn;
    ArrayList<Restaurantreview> restaurantreviews;
    SpinKitView spin_kitfortabreviewfragment;
    View v;
   /* String resid;
    String uid;
    String revdesc;
    float rating1;*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_tab_reviews, container, false);
        homepage=(Homepage) getActivity();
        Homepage.toolbar.setVisibility(View.GONE);
        setHasOptionsMenu(true);
        review_btn=v.findViewById(R.id.review_btn);
        spin_kitfortabreviewfragment=v.findViewById(R.id.spin_kitfortabreviewfragment);
        restaurantreviews = new ArrayList<>();
        rev_recycler=v.findViewById(R.id.rev_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rev_recycler.setLayoutManager(layoutManager);
        spin_kitfortabreviewfragment.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = homepage.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String h_id= sharedPreferences.getString("hotel_id", null);
        String u_id=  sharedPreferences.getString("uid", null);
        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<ResultRestaurantreview> call = apInterface.showrestreview(h_id);
        call.enqueue(new Callback<ResultRestaurantreview>() {
            @Override
            public void onResponse(Call<ResultRestaurantreview> call, Response<ResultRestaurantreview> response) {
                restaurantreviews = (ArrayList<Restaurantreview>) response.body().getRestaurantreview();
                review_adapter = new Review_adapter(getActivity(), restaurantreviews);
                rev_recycler.setAdapter(review_adapter);
                spin_kitfortabreviewfragment.setVisibility(View.GONE);
                SharedPreferences pref1 = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                String uid=pref1.getString("uid",null);
                Toast.makeText(getActivity(), "UID"+uid, Toast.LENGTH_SHORT).show();
                for(int i=0; i<restaurantreviews.size();i++) {
                    try {
                        if (restaurantreviews.get(i).getU_id().contains(uid)) {
                            review_btn.setVisibility(View.INVISIBLE);
                        }
                    } catch (Exception e)
                    {

                    }

                }
            }

            @Override
            public void onFailure(Call<ResultRestaurantreview> call, Throwable t) {
                spin_kitfortabreviewfragment.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Not responding", Toast.LENGTH_SHORT).show();
            }
        });

        review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent=new Intent(getActivity().getApplication(), Rate_us_restaurant.class);
                startActivity(intent);*/
                Rate_us_restaurant rate_us_restaurant = new Rate_us_restaurant(getActivity(),Rate_us_restaurant.class);
                rate_us_restaurant.getWindow().setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(android.R.color.transparent)));
                rate_us_restaurant.setCancelable(false);
                rate_us_restaurant.show();
               //rate_us_restaurant.dismiss();


               /* SharedPreferences sharedPreferences = homepage.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("hotel_id", hotel_id);
                editor.putString("hotel_name", hotel_name);
                editor.putString("hotel_add", hotel_add);
                editor.putString("hotel_cost", hotel_cost);
                editor.putString("hotel_location", hotel_location);
                editor.putString("tbldate", tbldate);
                editor.putString("foodies",foodies) ;
                editor.putString("rescontact",rescontact) ;
                editor.putString("hotel_hours", hotel_hours);
                editor.apply();*/



            }
        });



        return v;
    }

   /* private void setrev_recycler(ArrayList<Review_model> review_models) {

        rev_recycler = v.findViewById(R.id.rev_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rev_recycler.setLayoutManager(layoutManager);
        review_adapter = new Review_adapter(getActivity(), review_models);
        rev_recycler.setAdapter(review_adapter);

    }*/

}