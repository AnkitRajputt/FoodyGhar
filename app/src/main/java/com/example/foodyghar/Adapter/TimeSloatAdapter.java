package com.example.foodyghar.Adapter;

import static com.example.foodyghar.R.color.purple_200;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Model.Timeslot;
import com.example.foodyghar.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class TimeSloatAdapter extends RecyclerView.Adapter<TimeSloatAdapter.Myviewholder> {

    Context context;
    ArrayList<Timeslot> arrayListtiemslot;
    private RadioGroup lastCheckedRB = null;
    public static String Mytime;

    public TimeSloatAdapter(Context context, ArrayList<Timeslot> arrayListtiemslot) {
        this.context = context;
        this.arrayListtiemslot = arrayListtiemslot;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.timesloty, parent, false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, @SuppressLint("RecyclerView") int position) {
       // holder.textView.setText("" + arrayListtiemslot.get(position).getSloat());
        int id = (position + 1) * 100;
        RadioButton rb = null;
        for (Timeslot price : arrayListtiemslot) {
            rb = new RadioButton(context);
            rb.setId(id++);
            rb.setText(arrayListtiemslot.get(position).getSloat());
            holder.group.addView(rb);
        }
        holder.group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (lastCheckedRB != null
                        && lastCheckedRB.getCheckedRadioButtonId()
                        != holder.group.getCheckedRadioButtonId()
                        && lastCheckedRB.getCheckedRadioButtonId() != -1)
                {
                    lastCheckedRB.clearCheck();

                    Toast.makeText(
                            context,
                            "Your Selected time is " + arrayListtiemslot.get(position).getSloat(),
                            Toast.LENGTH_SHORT
                    ).show();
                    Mytime = arrayListtiemslot.get(position).getSloat();
                    Log.e("MYTIME", Mytime);
                }
                Toast.makeText(
                        context,
                        "Your Selected time is " + arrayListtiemslot.get(position).getSloat(),
                        Toast.LENGTH_SHORT
                ).show();
                Mytime = arrayListtiemslot.get(position).getSloat();
                Log.e("MYTIME", Mytime);
                lastCheckedRB = holder.group;
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayListtiemslot.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {

        RadioGroup group;

        TextView textView;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            group = itemView.findViewById(R.id.action_chip1);
            textView=itemView.findViewById(R.id.slottime);
        }
    }
}
