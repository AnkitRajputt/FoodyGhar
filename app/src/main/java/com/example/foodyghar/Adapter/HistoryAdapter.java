package com.example.foodyghar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.Carttable;
import com.example.foodyghar.Model.FoodmenuCategory;
import com.example.foodyghar.R;
import com.example.foodyghar.frag.Tab_myorder;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Viewholder> {

    ArrayList<Carttable> carttableArrayList;

    Context context;
    Homepage homepage;
    String cartid, uid;

    public HistoryAdapter(ArrayList<Carttable> carttableArrayList,Context context) {
        this.carttableArrayList = carttableArrayList;
        this.context = context;
        homepage = (Homepage) context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_order_details, parent, false);
        Viewholder viewHolder = new Viewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        holder.orderid.setText(carttableArrayList.get(position).getCartId());
        holder.itemqty.setText(""+carttableArrayList.get(position).getTotal_item());
        holder.book_id.setText(sharedPreferences.getString("b_id", ""));
        holder.date.setText(sharedPreferences.getString("b_date", ""));
        holder.order_restname.setText(sharedPreferences.getString("hotel_name", ""));
        holder.name.setText(sharedPreferences.getString("firstname", ""));
        holder.emailid.setText(sharedPreferences.getString("emailid", ""));
        holder.mobile.setText(sharedPreferences.getString("contact", ""));
        holder.no_people.setText(sharedPreferences.getString("b_tbm", ""));
        holder.reachtime.setText(sharedPreferences.getString("b_tslot", ""));
        holder.tablepay.setText(sharedPreferences.getString("hotel_cost", ""));
        holder.foodpay.setText(sharedPreferences.getString("hotel_cost", ""));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tab_myorder tab_about = new Tab_myorder();
                FragmentTransaction ft = homepage.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, tab_about);
                ft.addToBackStack("back");
                ft.commit();

            }
        });

    }


    @Override
    public int getItemCount() {
        return carttableArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView orderid, book_id, order_restname, name, date, emailid, mobile, itemqty, no_people, reachtime, tablepay, foodpay;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            orderid = itemView.findViewById(R.id.order_id);
            book_id = itemView.findViewById(R.id.book_id);
            date = itemView.findViewById(R.id.pay_date);
            order_restname = itemView.findViewById(R.id.order_restname);
            name = itemView.findViewById(R.id.user_name);
            emailid = itemView.findViewById(R.id.user_email);
            mobile = itemView.findViewById(R.id.user_phone);
            itemqty = itemView.findViewById(R.id.itemqty);
            no_people = itemView.findViewById(R.id.no_people);
            reachtime = itemView.findViewById(R.id.reachtime);
            tablepay = itemView.findViewById(R.id.table_payment);
            foodpay = itemView.findViewById(R.id.food_payment);

        }
    }
}
