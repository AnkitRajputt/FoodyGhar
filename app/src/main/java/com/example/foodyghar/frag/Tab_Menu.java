package com.example.foodyghar.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodyghar.Adapter.FoodAdapter1;
import com.example.foodyghar.Adapter.Tab_menu_AsiaFoodAdapter;
import com.example.foodyghar.Adapter.Tab_menu_PopularFoodAdapter;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.FoodmenuCategory;
import com.example.foodyghar.Model.GetfoodImage;
import com.example.foodyghar.Model.Getfoodimg;
import com.example.foodyghar.Model.Resultfoodmenu;
import com.example.foodyghar.R;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Tab_Menu extends Fragment {

    RecyclerView popularRecycler, asiaRecycler;
    ImageView back_page_menu;
    Tab_menu_PopularFoodAdapter tab_menu_popularFoodAdapter;
    Tab_menu_AsiaFoodAdapter tab_menu_asiaFoodAdapter;
    Homepage homepage;
    View v;
    SliderView sliderView;

    ArrayList<GetfoodImage> getfoodImage;

    ArrayList<FoodmenuCategory> arraypopularFoodList;
    ArrayList<FoodmenuCategory> arrayasiaFoodList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tabmenu_frag, container, false);
        popularRecycler = v.findViewById(R.id.popular_recycler);
        asiaRecycler = v.findViewById(R.id.asia_recycler);
        homepage = (Homepage) getActivity();
        Homepage.toolbar.setVisibility(View.GONE);
        setHasOptionsMenu(true);
        back_page_menu = v.findViewById(R.id.back_page_menu);
       /* back_page_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab_home_tblbook_confirm tbl_book_confirm=new Tab_home_tblbook_confirm();
                FragmentTransaction ft= homepage.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout,tbl_book_confirm);
                ft.addToBackStack("back");
                ft.commit();
            }
        });*/

        APInterface apInterface1 = APIClient.getClient().create(APInterface.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String res_id = sharedPreferences.getString("res_id", "");
        Log.e("RES_ID", res_id);
        Call<Getfoodimg> getImageCall = apInterface1.getFoodSliderImage(res_id);
        getImageCall.enqueue(new Callback<Getfoodimg>() {
            @Override
            public void onResponse(Call<Getfoodimg> call, Response<Getfoodimg> response) {
                try {
                    getfoodImage = (ArrayList<GetfoodImage>) response.body().getGetfoodImages();
                    FoodAdapter1 foodAdapter1 = new FoodAdapter1(getActivity(), getfoodImage);
                    sliderView.setSliderAdapter(foodAdapter1);
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<Getfoodimg> call, Throwable t) {

            }
        });


        SharedPreferences share = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String idofuser = share.getString("hotel_id", null);
        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<Resultfoodmenu> call = apInterface.getFoodmenuCategory(String.valueOf(idofuser));
        call.enqueue(new Callback<Resultfoodmenu>() {
            @Override
            public void onResponse(Call<Resultfoodmenu> call, Response<Resultfoodmenu> response) {

                arrayasiaFoodList = (ArrayList<FoodmenuCategory>) response.body().getFoodmenuCategory();
                RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
                asiaRecycler.setLayoutManager(layoutManager2);
                tab_menu_asiaFoodAdapter = new Tab_menu_AsiaFoodAdapter(getActivity(), arrayasiaFoodList);
                asiaRecycler.setAdapter(tab_menu_asiaFoodAdapter);

            }

            @Override
            public void onFailure(Call<Resultfoodmenu> call, Throwable t) {
                Toast.makeText(getActivity(), "not show item", Toast.LENGTH_SHORT).show();
            }
        });
        APInterface apInterface2 = APIClient.getClient().create(APInterface.class);
        Call<Resultfoodmenu> call1 = apInterface2.getFoodmenulayout(String.valueOf(idofuser));
        call1.enqueue(new Callback<Resultfoodmenu>() {
            @Override
            public void onResponse(Call<Resultfoodmenu> call, Response<Resultfoodmenu> response) {
                arraypopularFoodList = (ArrayList<FoodmenuCategory>) response.body().getFoodmenuCategory();
                //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
               /* HorizontalScrollView horizontalScrollView=new HorizontalScrollView(getActivity());
                popularRecycler.setLayoutManager(horizontalScrollView);
                tab_menu_popularFoodAdapter=new Tab_menu_PopularFoodAdapter(getActivity(),arraypopularFoodList);
                popularRecycler.setAdapter(tab_menu_popularFoodAdapter);*/
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                popularRecycler.setLayoutManager(layoutManager);
                tab_menu_popularFoodAdapter = new Tab_menu_PopularFoodAdapter(getActivity(), arraypopularFoodList);
                popularRecycler.setAdapter(tab_menu_popularFoodAdapter);

            }

            @Override
            public void onFailure(Call<Resultfoodmenu> call, Throwable t) {

            }
        });
       /* List<Tab_menu_PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new Tab_menu_PopularFood("Float Cake Vietnam", "$7.05", R.drawable.popularfood1));
        popularFoodList.add(new Tab_menu_PopularFood("Chiken Drumstick", "$17.05", R.drawable.popularfood2));
        popularFoodList.add(new Tab_menu_PopularFood("Fish Tikka Stick", "$25.05", R.drawable.popularfood3));
        popularFoodList.add(new Tab_menu_PopularFood("Float Cake Vietnam", "$7.05", R.drawable.popularfood1));
        popularFoodList.add(new Tab_menu_PopularFood("Chiken Drumstick", "$17.05", R.drawable.popularfood2));
        popularFoodList.add(new Tab_menu_PopularFood("Fish Tikka Stick", "$25.05", R.drawable.popularfood3));

        setPopularRecycler(popularFoodList);


        List<Tab_menu_AsiaFood> asiaFoodList = new ArrayList<>();
        asiaFoodList.add(new Tab_menu_AsiaFood("Chicago Pizza", "₹20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new Tab_menu_AsiaFood("Straberry Cake", "₹25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new Tab_menu_AsiaFood("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new Tab_menu_AsiaFood("Straberry Cake", "$25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new Tab_menu_AsiaFood("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new Tab_menu_AsiaFood("Straberry Cake", "$25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));

        setAsiaRecycler(asiaFoodList);
*/
        return v;
    }

   /* private void setPopularRecycler(List<Tab_menu_PopularFood> popularFoodList) {

        popularRecycler = v.findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        tab_menu_popularFoodAdapter = new Tab_menu_PopularFoodAdapter(getActivity(), popularFoodList);
        popularRecycler.setAdapter(tab_menu_popularFoodAdapter);

    }

    private void setAsiaRecycler(List<Tab_menu_AsiaFood> asiaFoodList) {

        asiaRecycler = v.findViewById(R.id.asia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        asiaRecycler.setLayoutManager(layoutManager);
        tab_menu_asiaFoodAdapter = new Tab_menu_AsiaFoodAdapter(getActivity(), asiaFoodList);
        asiaRecycler.setAdapter(tab_menu_asiaFoodAdapter);

    }*/

}

