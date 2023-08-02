package com.example.foodyghar.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.Model.Restaurantreview;
import com.example.foodyghar.Model.ResultRestaurantreview;
import com.example.foodyghar.R;
import com.example.foodyghar.frag.Tab_Reviews;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Review_adapter extends RecyclerView.Adapter<Review_adapter.dbmyviewholder>
{
    Context context;
    ArrayList<Restaurantreview>arrayList;
   // static ArrayList<RestaurantCategory>restaurantCategories;
    Homepage homepage;


    public Review_adapter(Context context, ArrayList<Restaurantreview> arrayList ) {
        this.context = context;
        this.arrayList = arrayList;
       // this.restaurantCategories = restaurantCategories;
        homepage= (Homepage) context;
    }

    @NonNull
    @Override
    public dbmyviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_review,parent,false);
        return new dbmyviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull dbmyviewholder holder, int position) {
       // holder.imageUrl.setImageResource(arrayList.get(position).getImageUrl());
        Picasso.get().load(arrayList.get(position).getImg()).resize(150, 150).into(holder.imageUrl);
        holder.username.setText(arrayList.get(position).getFirstname());
        float i=Math.round((arrayList.get(position).getRating()));
        holder.rest_rate_tv.setText(i +"");
        holder.rev_des.setText(arrayList.get(position).getRevDesc());
      //  holder.rest_ratingbar.setRating(i+"");
        SharedPreferences sharedPreferences = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Toast.makeText(context, "" + hotel_id, Toast.LENGTH_SHORT).show();
        editor.putString("hotel_rate", String.valueOf(i));
        editor.apply();


        SharedPreferences pref = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String fname = pref.getString("fname", null);
        String lname = pref.getString("lname",null);
        String h_rate = pref.getString("hotel_rate", null);
        String u_rev = pref.getString("userrev", null);

       // holder.imageUrl.setImageURI(fname);
       /* holder.username.setText(fname);
        holder.rest_rate_cardtext.setText(h_rate);
        holder.rest_rate_tv.setText(h_rate);*/
      // holder.rev_des.setText(u_rev);

       holder.rest_ratingbar.setRating(arrayList.get(position).getRating());
       holder.rest_rate_cardtext.setText(i+"");

    }



    @Override
    public int getItemCount() {
      return arrayList.size();
    }

    class dbmyviewholder extends RecyclerView.ViewHolder
    {
        ImageView imageUrl;
        TextView username,rest_rate_tv,rest_rate_cardtext,rev_des;
        RatingBar rest_ratingbar;


        public dbmyviewholder(@NonNull View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.rev_img);
            username = itemView.findViewById(R.id.rev_user);
            rest_rate_tv = itemView.findViewById(R.id.rest_rate_tv);
            rest_rate_cardtext = itemView.findViewById(R.id.rest_rate_cardtext);
            rev_des = itemView.findViewById(R.id.rev_des);
            rest_ratingbar = itemView.findViewById(R.id.rest_ratingbar);





        }
    }
}
