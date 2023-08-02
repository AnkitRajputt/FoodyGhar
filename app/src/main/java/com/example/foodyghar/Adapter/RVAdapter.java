package com.example.foodyghar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.DownloadImageOffline;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.R;
import com.example.foodyghar.Model.User;
import com.example.foodyghar.frag.Hotel_detail_fragment;
import com.example.foodyghar.frag.Tab_Home;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.myviewholder> implements Filterable {
    Context context;
    ArrayList<RestaurantCategory> arrayList;
    ArrayList<RestaurantCategory> storearrayList;
    Homepage homepage;
    String hotel_id,hotel_name,hotel_add,hotel_cost,hotel_location,
            tbldate,foodies,rescontact,hotel_hours;
    String hotel_rate;

    public RVAdapter(Context context, ArrayList<RestaurantCategory> arrayList) {
        this.context = context;
        homepage = (Homepage) context;
        this.arrayList = arrayList;
        this.storearrayList = new ArrayList<>(arrayList);   //assign arraylistvalue in another arraylist
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.tv1.setText(arrayList.get(position).getName());
        holder.tv2.setText(arrayList.get(position).getAddress());
        holder.tv3.setText(arrayList.get(position).getHours());

        Log.e("HOTELIMG", arrayList.get(position).getRes_image());
        Picasso.get().load(arrayList.get(position).getRes_image()).resize(150, 150).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Hotel_detail_fragment hotel_detail_fragment = new Hotel_detail_fragment();
                FragmentTransaction ft = homepage.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, hotel_detail_fragment);
                hotel_id = arrayList.get(position).getId();
                hotel_name=arrayList.get(position).getName();
                hotel_add=arrayList.get(position).getAddress();
                hotel_cost=arrayList.get(position).getTblcost();
                hotel_rate=arrayList.get(position).getResrate();
                hotel_location=arrayList.get(position).getReslocation();
                tbldate=arrayList.get(position).getTbldate();
                foodies=arrayList.get(position).getFoodies();
                rescontact=arrayList.get(position).getRescontact();
                hotel_hours=arrayList.get(position).getHours();

                SharedPreferences sharedPreferences = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // Toast.makeText(context, "" + hotel_id, Toast.LENGTH_SHORT).show();
                editor.putString("hotel_id", hotel_id);
                editor.putString("hotel_name", hotel_name);
                editor.putString("hotel_add", hotel_add);
                editor.putString("hotel_cost", hotel_cost);
                editor.putString("hotel_rate", hotel_rate);
                editor.putString("hotel_location", hotel_location);
                editor.putString("tbldate", tbldate);
                editor.putString("foodies",foodies) ;
                editor.putString("rescontact",rescontact) ;
                editor.putString("hotel_hours", hotel_hours);
                editor.apply();
                ft.addToBackStack("back");
                ft.commit();
            }
        });
    }


    @Override
    public Filter getFilter() {
        return search_filter;
    }

    private Filter search_filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<RestaurantCategory> filterarraylist = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterarraylist.addAll(storearrayList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (RestaurantCategory item : storearrayList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filterarraylist.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterarraylist;
            return results;

        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList.clear();
            arrayList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        SpinKitView spinKitView;
        ImageView iv;
        TextView tv1, tv2, tv3;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.img_avatar);
            spinKitView = itemView.findViewById(R.id.spin_kitforhomefragment);
            tv1 = itemView.findViewById(R.id.tv_name);
            tv2 = itemView.findViewById(R.id.tv_address);
            tv3 = itemView.findViewById(R.id.tv_time);

        }
    }
}




