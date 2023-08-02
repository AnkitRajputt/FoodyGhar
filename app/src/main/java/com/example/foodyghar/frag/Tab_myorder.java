package com.example.foodyghar.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodyghar.Adapter.HistoryAdapter;
import com.example.foodyghar.Model.Carttable;
import com.example.foodyghar.Model.FoodmenuCategory;
import com.example.foodyghar.Model.Resultcarttable;
import com.example.foodyghar.R;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Tab_myorder extends Fragment {
    RecyclerView recyclerView2;
    ArrayList<Carttable> carttableArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab_about, container, false);

        recyclerView2 = view.findViewById(R.id.rec_order);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        carttableArrayList = new ArrayList<>();


        SharedPreferences shared = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String userid = shared.getString("uid", null);
        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<Resultcarttable> call = apInterface.showmyorder(userid);
        call.enqueue(new Callback<Resultcarttable>() {
            @Override
            public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                carttableArrayList= (ArrayList<Carttable>) response.body().getCarttable();
                HistoryAdapter historyAdapter=new HistoryAdapter(carttableArrayList,getActivity());
                recyclerView2.setAdapter(historyAdapter);
                //spinKitView.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<Resultcarttable> call, Throwable t) {
                //  spinKitView.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Not responding", Toast.LENGTH_SHORT).show();
            }

        });

        return view;
    }
}