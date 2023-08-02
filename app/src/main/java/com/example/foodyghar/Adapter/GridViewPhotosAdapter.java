package com.example.foodyghar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Model.DowloadAllPhotos;
import com.example.foodyghar.Model.GetImage__1;
import com.example.foodyghar.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewPhotosAdapter extends BaseAdapter {
    Context context;
    ArrayList<GetImage__1> getImage__1s = new ArrayList<>();
    ProgressBar progressBar;
    private static LayoutInflater inflater = null;

    public GridViewPhotosAdapter(Context context, ArrayList<GetImage__1> getImage__1s, ProgressBar progressBar) {

        this.context = context;
        this.getImage__1s = getImage__1s;
        this.progressBar = progressBar;
    }

    @Override
    public int getCount() {
        return getImage__1s.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflter = LayoutInflater.from(context);
        view = inflter.inflate(R.layout.tab_photos_card_item, null);
        ImageView imageView = view.findViewById(R.id.idIVcourse);
//        Toast.makeText(context, "" + getImage__1s.get(i).getResimg(), Toast.LENGTH_SHORT).show();
        Picasso.get().load(getImage__1s.get(i).getResimg()).resize(150, 150).into(imageView);
        progressBar.setVisibility(View.INVISIBLE);
        return view;
    }
}