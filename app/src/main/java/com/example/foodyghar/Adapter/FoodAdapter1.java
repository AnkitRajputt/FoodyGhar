package com.example.foodyghar.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodyghar.Model.DownloadImageOffline;
import com.example.foodyghar.Model.GetfoodImage;
import com.example.foodyghar.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodAdapter1 extends SliderViewAdapter<FoodAdapter1.Holder> {

    Context context;
    ArrayList<GetfoodImage> GetfoodImages;

    public FoodAdapter1(Context context, ArrayList<GetfoodImage> GetfoodImages) {
        this.context=context;
        this.GetfoodImages=GetfoodImages;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tab_menu_popular_food, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        //Toast.makeText(context, ""+GetfoodImages.get(position).getFoodimg(), Toast.LENGTH_SHORT).show();

        Picasso.get().load(GetfoodImages.get(position).getFoodimg()).resize(150, 150).into(viewHolder.imageView);

        // Toast.makeText(context, "" + GetfoodImages.size(), Toast.LENGTH_SHORT).show();

        Log.e("SLIDER", GetfoodImages.get(position).getFoodimg());

        new DownloadImageOffline(context, viewHolder.imageView).execute(GetfoodImages.get(position).getFoodimg());
    }

    @Override
    public int getCount() {
        return GetfoodImages.size();
    }

    public class Holder extends ViewHolder {
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_image);
        }
    }
}
