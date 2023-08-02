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

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.FoodmenuCategory;
import com.example.foodyghar.Model.Tab_menu_PopularFood;
import com.example.foodyghar.R;
import com.example.foodyghar.Tab_menu_details;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;


public class Tab_menu_PopularFoodAdapter extends RecyclerView.Adapter<Tab_menu_PopularFoodAdapter.PopularFoodViewHolder> {


    Context context;
    ArrayList<FoodmenuCategory> arraypopularFoodList;
    Homepage homepage;



    public Tab_menu_PopularFoodAdapter(Context context, ArrayList<FoodmenuCategory> arraypopularFoodList) {
        this.context = context;
        this.arraypopularFoodList = arraypopularFoodList;
        homepage= (Homepage) context;
    }

    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_menu_popular_food,parent,false);
        return new PopularFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // holder.foodImage.setImageResource(arraypopularFoodList.get(position).getFoodImg());
        Picasso.get().load(arraypopularFoodList.get(position).getFoodImg()).resize(150, 150).into(holder.foodImage);
        holder.foodname.setText(arraypopularFoodList.get(position).getFoodname());
        holder.foodprice.setText("₹ "+ arraypopularFoodList.get(position).getFoodprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,Tab_menu_details.class);
                intent.putExtra("FoodId",arraypopularFoodList.get(position).getFoodId());
                intent.putExtra("FoodName",holder.foodname.getText().toString());
                intent.putExtra("FoodPrice",arraypopularFoodList.get(position).getFoodprice());
                intent.putExtra("FoodImg",arraypopularFoodList.get(position).getFoodImg());
                context.startActivity(intent);





            }
        });

    }

    @Override
    public int getItemCount() {
        return arraypopularFoodList.size();
    }


    public static final class PopularFoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView foodprice, foodname;

        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            foodprice = itemView.findViewById(R.id.price);
            foodname = itemView.findViewById(R.id.name);

        }
    }

}
