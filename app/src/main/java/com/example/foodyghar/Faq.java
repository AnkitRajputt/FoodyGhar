package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodyghar.Adapter.Faq_Adapter;
import com.example.foodyghar.Model.Faq_model;

import java.util.ArrayList;
import java.util.List;

public class Faq extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Faq_model> faqModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        recyclerView = findViewById(R.id.faq);

        initData();
        setRecylerView();
    }
    private void setRecylerView() {
        Faq_Adapter faqAdapter = new Faq_Adapter(faqModelList);
        recyclerView.setAdapter(faqAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        faqModelList = new ArrayList<>();
        faqModelList.add(new Faq_model("How to download Foody Ghar ?","Go to playstore,type in searchbox foodyghar and press install button"));
        faqModelList.add(new Faq_model("Can I receive a refund?","No"));
        faqModelList.add(new Faq_model("Can I book table for reservations","Yes"));
        faqModelList.add(new Faq_model("Is there a preorder for foodmenu ?","Yes"));
        faqModelList.add(new Faq_model("Can I just visit the restaurents for any enquiry?","Yes"));

    }
}