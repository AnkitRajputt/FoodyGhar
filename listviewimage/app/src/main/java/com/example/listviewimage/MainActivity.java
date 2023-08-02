package com.example.listviewimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    String[] hotelname={"Sagar","winsome","satyam","bhagyoday"};
    String[] hoteldesc={"Sagar hotel near bibi talva","winsome hotel near bibi talva",
    "Satyam hotel near bibi talva","bhagyoday hotel near bibi talva"};
    int imgid[] ={R.drawable.hotel,R.drawable.img,R.drawable.img1,R.drawable.sss};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        Customlistview customlistview=new Customlistview(imgid,hotelname,hoteldesc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(customlistview);
    }
}