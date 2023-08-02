package com.example.foodyghar.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodyghar.Model.DownloadImageOffline;
import com.example.foodyghar.Model.GetImage__1;
import com.example.foodyghar.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SliderAdapter1 extends SliderViewAdapter<SliderAdapter1.Holder> {

    Context context;
    ArrayList<GetImage__1> getImage__1s;

    public SliderAdapter1(Context context, ArrayList<GetImage__1> getImage__1s) {
        this.context = context;
        this.getImage__1s = getImage__1s;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_image_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        Picasso.get().load(getImage__1s.get(position).getResimg()).
                resize(150, 150).into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        Log.e("COUNT", String.valueOf(getImage__1s.size()));
        Log.e("SLIDER", getImage__1s.get(0).getResimg());
        return getImage__1s.size();
    }

    public class Holder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_View);
        }
    }
}
