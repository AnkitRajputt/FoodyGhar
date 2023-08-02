package com.example.foodyghar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodyghar.Model.DowloadAllPhotos;
import com.example.foodyghar.Model.DownloadImageOffline;
import com.example.foodyghar.Model.GetImage__1;
import com.example.foodyghar.Model.Tab_photos_model;
import com.example.foodyghar.R;

import java.util.ArrayList;

public class Tab_photos_Gv_Adapter extends ArrayAdapter<Tab_photos_model> {

    Context context;
    ArrayList<GetImage__1> tab_photos_imagesArrayList;
    ProgressBar progressBar;
    public Tab_photos_Gv_Adapter(@NonNull Context context, ArrayList<GetImage__1> tab_photos_imagesArrayList, ProgressBar progressBar) {
        super(context, 0);
        this.context = context;
        this.tab_photos_imagesArrayList = tab_photos_imagesArrayList;
        this.progressBar = progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.tab_photos_card_item, null);
        }

        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);

        new DowloadAllPhotos(context, courseIV,progressBar).execute(tab_photos_imagesArrayList.get(position).getResimg());
        return listitemView;
    }
}
