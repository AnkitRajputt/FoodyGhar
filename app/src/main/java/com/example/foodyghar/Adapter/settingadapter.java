package com.example.foodyghar.Adapter;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.example.foodyghar.AboutCallPage;
import com.example.foodyghar.Appinfo;
import com.example.foodyghar.Faq;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Login;
import com.example.foodyghar.Model.SettingModel;
import com.example.foodyghar.R;
import com.example.foodyghar.RateUsDialog;
import com.example.foodyghar.TandC;

import java.util.ArrayList;
import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class settingadapter extends RecyclerView.Adapter<settingadapter.myviewholder> {
    ArrayList<SettingModel> arrayList;
    Context context;
    Homepage homepage;
    private static final String TAG = settingadapter.class.getSimpleName();


    public settingadapter(ArrayList<SettingModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        homepage = (Homepage) context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_row, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.txt.setText(arrayList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    Intent intent = new Intent(context, Appinfo.class);
                    homepage.startActivity(intent);
                }

                if (position == 3) {
                    showInfo();
                }


                if (position == 4) {
                    Intent intent = new Intent(context, Faq.class);
                    homepage.startActivity(intent);


                }

                if (position == 2) {
                    // showDialog();

                    RateUsDialog rateUsDialog = new RateUsDialog(context, RateUsDialog.class);
                    rateUsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
                    rateUsDialog.setCancelable(false);
                    rateUsDialog.show();

                }

                if (position == 1) {
                    Intent intent = new Intent(context, TandC.class);
                    homepage.startActivity(intent);
                }

                if (position == 5) {


                       /* Element adsElement = new Element();
                        adsElement.setTitle("Advertise with us");
                        View aboutPage = new AboutPage(context)
                                .isRTL(false)
                                .setImage(R.drawable.logo)
                                .addItem(new Element().setTitle("Version 1.0"))
                                .addItem(adsElement)
                                .addGroup("Connect with us")
                                .addEmail("ankitrajputsingh189@gmail.com")
                                .create();*/
                       // homepage.setContentView(aboutPage);

                    Intent intent = new Intent(context, AboutCallPage.class);
                    homepage.startActivity(intent);
                }

                if (position == 6) {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String sharebody = "Checkout this App";
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                    context.startActivity(Intent.createChooser(sharingIntent, "Share via"));

                }

                if (position == 7) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setMessage("Are you sure want to logout ?");
                    alertDialog.setTitle("Logout");
                    alertDialog.setCancelable(false);

                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            SharedPreferences pref = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = pref.edit();
                            ed.putBoolean("skip", false);
                            ed.apply();
                            Intent intent = new Intent(context, Login.class);
                            homepage.startActivity(intent);
                            Toast.makeText(context, "Logout Successfully", Toast.LENGTH_SHORT).show();
                            homepage.finish();

                        }
                    });

                    alertDialog.setNeutralButton("CANCEL",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // code to do on CANCEL tapped
                                    dialog.cancel();
                                }
                            });

                    alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });


                    AlertDialog dialog = alertDialog.create();
                    dialog.show();


                    SharedPreferences pref = context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putBoolean("isLog", false);
                    ed.apply();


                }

                if (position == 8) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

// set the title of the Alert Dialog
                    alertDialogBuilder.setTitle("Alert !");

// set dialog message
                    alertDialogBuilder.setMessage("Do you want to exit ?");

                    alertDialogBuilder.setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // what to do if YES is tapped
                                    homepage.finishAffinity();
                                    System.exit(0);
                                }
                            });


                    alertDialogBuilder.setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // code to do on NO tapped
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();

                    alertDialog.show();
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txt;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img1);
            txt = itemView.findViewById(R.id.txt1);
        }
    }

 /*   private void showDialog() {

        final RatingDialog ratingDialog = new RatingDialog.Builder(context)

                .session(1)
                .threshold(3)
                .ratingBarColor(R.color.yellow)
                //.playstoreUrl("https://github.com/codemybrainsout/smart-app-rate")
                .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                    @Override
                    public void onFormSubmitted(String feedback) {
                        Log.i(TAG, "Feedback:" + feedback);
                    }
                })



                .build();


        ratingDialog.show();
    }*/

    private void showInfo() {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + "com.example.foodyghar"));
            homepage.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            context.startActivity(intent);
        }
    }

}
