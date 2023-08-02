package com.example.listviewimage;

import static com.example.listviewimage.R.layout.*;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class Customlistview extends RecyclerView.Adapter<Customlistview.Holder> {

    int img[];
    String hotelname[];
    String hotedes[];

    public Customlistview(int[] img, String[] hotelname, String[] hotedes) {
        this.img = img;
        this.hotelname = hotelname;
        this.hotedes = hotedes;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(homepagelistview,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.imageView.setImageResource(img[position]);
        holder.txt1.setText(hotelname[position]);
        holder.txt2.setText(hotedes[position]);

    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    class Holder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView txt1,txt2;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            txt1 = itemView.findViewById(R.id.htlname);
            txt2 = itemView.findViewById(R.id.htldesc);

        }
    }


}
