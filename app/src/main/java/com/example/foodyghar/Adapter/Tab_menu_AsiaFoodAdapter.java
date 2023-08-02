package com.example.foodyghar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.FoodmenuCategory;
import com.example.foodyghar.Model.Tab_menu_AsiaFood;
import com.example.foodyghar.R;
import com.example.foodyghar.Tab_menu_details;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Tab_menu_AsiaFoodAdapter extends RecyclerView.Adapter<Tab_menu_AsiaFoodAdapter.AsiaFoodViewHolder> {


    Context context;
    /*List<Tab_menu_AsiaFood> asiaFoodList;*/
    ArrayList<FoodmenuCategory> arrayasiaFoodList;
    Homepage homepage;


    public Tab_menu_AsiaFoodAdapter(Context context, ArrayList<FoodmenuCategory> arrayasiaFoodList) {
        this.context = context;
        this.arrayasiaFoodList = arrayasiaFoodList;
        homepage = (Homepage) context;
    }

    @NonNull
    @Override
    public AsiaFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_menu_asia_food, parent, false);
        return new AsiaFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AsiaFoodViewHolder holder, @SuppressLint("RecyclerView") int position) {

        //holder.foodImage.setImageResource(asiaFoodList.get(position).getImageUrl());
        Picasso.get().load(arrayasiaFoodList.get(position).getFoodImg()).resize(150, 150).into(holder.foodImage);
        holder.foodname.setText(arrayasiaFoodList.get(position).getFoodname());
        holder.foodprice.setText("₹ "+ arrayasiaFoodList.get(position).getFoodprice());
        //holder.rating.setText(arrayasiaFoodList.get(position).getRating());
        // holder.restorantName.setText(arrayasiaFoodList.get(position).getRestorantname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,Tab_menu_details.class);
                intent.putExtra("FoodId",arrayasiaFoodList.get(position).getFoodId());
                intent.putExtra("FoodName",holder.foodname.getText().toString());
                intent.putExtra("FoodPrice",arrayasiaFoodList.get(position).getFoodprice());
                intent.putExtra("FoodImg",arrayasiaFoodList.get(position).getFoodImg());
                context.startActivity(intent);




            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayasiaFoodList.size();
    }


    public static final class AsiaFoodViewHolder extends RecyclerView.ViewHolder {


        ImageView foodImage;
        TextView foodprice, foodname;



        public AsiaFoodViewHolder(@NonNull View view) {
            super(view);

            foodImage = view.findViewById(R.id.food_image);
            foodprice = view.findViewById(R.id.price);
            foodname = view.findViewById(R.id.name);

            // rating = view.findViewById(R.id.rating);
            // restorantName = view.findViewById(R.id.restorant_name);


        }
    }


}
