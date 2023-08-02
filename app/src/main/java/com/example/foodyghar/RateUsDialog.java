package com.example.foodyghar;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RateUsDialog extends Dialog {

    String rid;
    String fid;

    private float Userrate = 0;
    public RateUsDialog(@NonNull Context context, Class<RateUsDialog> rateUsDialogClass) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dialog);

        final AppCompatButton ratenowbtn = findViewById(R.id.ratenow_btn);
        final AppCompatButton laterbtn = findViewById(R.id.later_btn);
        final RatingBar ratingbar = findViewById(R.id.ratingbar);
        final ImageView ratingimage = findViewById(R.id.rating_image);
        final EditText feedback = findViewById(R.id.et_feedback);

        SharedPreferences pref= getContext().getSharedPreferences("mypref",Context.MODE_PRIVATE);
        rid=pref.getString("uid", null);
        fid=pref.getString("uid", null);

        ratenowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feeds =feedback.getText().toString();

                APInterface apInterface= APIClient.getClient().create(APInterface.class);
                Call<Resultlogin>call= apInterface.insertfeedback(fid,feeds);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        Toast.makeText(getContext(), "Thank You for your review", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        /*feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String feeds =feedback.getText().toString();

            }
        });*/

        laterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hide rating bar
                dismiss();
            }
        });

      /*  ratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float ratestar =ratingbar.getRating();




            }
        });*/


        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromuser) {
                float ratestar =ratingbar.getRating();

                if(rating <= 1){
                    ratingimage.setImageResource(R.drawable.one_star);
                }
                else if(rating <= 2){
                    ratingimage.setImageResource(R.drawable.two_star);
                }
                else if(rating <= 3){
                    ratingimage.setImageResource(R.drawable.three_star);
                }
                else if(rating <= 4){
                    ratingimage.setImageResource(R.drawable.four_star);
                }
                else if(rating <= 5){
                    ratingimage.setImageResource(R.drawable.five_star);
                }
                // animate emoji image
                animateImage(ratingimage);

                //selected rating by user
                Userrate = rating;
                APInterface apInterface= APIClient.getClient().create(APInterface.class);
                Call<Resultlogin>call= apInterface.insertrating(rid,ratestar);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        Toast.makeText(getContext(), "Thanks for Rating"
                                , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }

    private void animateImage(ImageView ratingimage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f, 0, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingimage.startAnimation(scaleAnimation);


    }


}
