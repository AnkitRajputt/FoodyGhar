package com.example.foodyghar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodyghar.Model.Carttable;
import com.example.foodyghar.Model.Resultcarttable;
import com.example.foodyghar.R;
import com.example.foodyghar.Tab_Menu_AddtoCart;
import com.example.foodyghar.Tab_menu_details;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    Context context;
    ArrayList<Carttable> arrayList;
    Tab_Menu_AddtoCart homepage;
  //  ProgressBar progressBar;

    public CartAdapter(Context context, ArrayList<Carttable> arrayList) {
        this.context = context;
        homepage = (Tab_Menu_AddtoCart) context;
        this.arrayList = arrayList;
      //  this.progressBar=progressBar;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.simplecart, parent, false);
        Viewholder viewHolder = new Viewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.foodnames.setText(arrayList.get(position).getFoodname());
        holder.foodprices.setText("₹" + Integer.parseInt(arrayList.get(position).getFoodprice()) * arrayList.get(position).getTotal_item() + "");
        holder.foodtotalqun.setText(String.valueOf(arrayList.get(position).getTotal_item()));

        Picasso.get().load(arrayList.get(position).getFoodImg()).into(holder.foodimg);


        holder.deleteimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APInterface apInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultcarttable> call = apInterface.deletecart(arrayList.get(position).getCartId());
                call.enqueue(new Callback<Resultcarttable>() {
                    @Override
                    public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                        Toast.makeText(context, "delete cart ", Toast.LENGTH_SHORT).show();
                        Tab_Menu_AddtoCart.add();
                        //progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<Resultcarttable> call, Throwable t) {
                       // progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView foodimg, deleteimg;
        TextView foodnames, foodprices, foodtotalqun;
        //  ElegantNumberButton elegantNumberButton;

        public Viewholder(@NonNull View itemView) {

            super(itemView);
            foodimg = itemView.findViewById(R.id.foodimg);
            deleteimg = itemView.findViewById(R.id.deleteitem);
            foodnames = itemView.findViewById(R.id.foodname);
            foodprices = itemView.findViewById(R.id.foodprice);
            foodtotalqun = itemView.findViewById(R.id.qty);
            //elegantNumberButton = itemView.findViewById(R.id.quantity_btn);
        }
    }
}
