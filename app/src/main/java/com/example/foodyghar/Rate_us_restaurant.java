package com.example.foodyghar;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.example.foodyghar.Model.ResultRestaurantreview;
import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.R;
import com.example.foodyghar.RateUsDialog;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rate_us_restaurant extends Dialog{

   /* String h_id;
    String u_id;*/


    private float Userrestaurent = 0;

    public Rate_us_restaurant(@NonNull Context context, Class<Rate_us_restaurant> rateusRestaurentClass) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_restaurent);

        final Button submit_btn_restaurent = findViewById(R.id.submit_btn);
        final Button later_btn_restaurent = findViewById(R.id.laterrest_btn);
        final RatingBar ratingbar_for_restarent = findViewById(R.id.ratebar_restarent);
     //   final ImageView rating_image_restreview = findViewById(R.id.rating_image_restreview);
        final EditText et_review_restaurent = findViewById(R.id.et_review_restaurent);

        SharedPreferences pref= getContext().getSharedPreferences("mypref",Context.MODE_PRIVATE);
       String h_id=pref.getString("hotel_id",null);
       String u_id=pref.getString("uid",null);


        submit_btn_restaurent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float ratestar =ratingbar_for_restarent.getRating();
                String review =et_review_restaurent.getText().toString();

                APInterface apInterface= APIClient.getClient().create(APInterface.class);
                Call<ResultRestaurantreview> call= apInterface.getrestreview(h_id,u_id,review,ratestar);
                call.enqueue(new Callback<ResultRestaurantreview>() {
                    @Override
                    public void onResponse(Call<ResultRestaurantreview> call, Response<ResultRestaurantreview> response) {
                        Toast.makeText(getContext(), "Thank You for rating", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }

                    @Override
                    public void onFailure(Call<ResultRestaurantreview> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        dismiss();

                    }
                    SharedPreferences pref = getContext().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = pref.edit();
                          /*  ed.putString("eml", el);
                            ed.putString("password", ps);*/


                });




            }
        });

        et_review_restaurent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  String feeds =et_review_restaurent.getText().toString();

            }
        });

        later_btn_restaurent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hide rating bar
                dismiss();
            }
        });

        ratingbar_for_restarent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  float ratestar =ratingbar_for_restarent.getRating();




            }
        });


        ratingbar_for_restarent.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromuser) {

               /* float ratestar =ratingbar_for_restarent.getRating();
                String review =et_review_restaurent.getText().toString();*/
                if(rating <= 1){
                    //ratingimage.setImageResource(R.drawable.one_star);
                }
                else if(rating <= 2){
                    //ratingimage.setImageResource(R.drawable.two_star);
                }
                else if(rating <= 3){
                    //ratingimage.setImageResource(R.drawable.three_star);
                }
                else if(rating <= 4){
                    //ratingimage.setImageResource(R.drawable.four_star);
                }
                else if(rating <= 5){
                    //ratingimage.setImageResource(R.drawable.five_star);
                }
                Userrestaurent = rating;
                /*APInterface apInterface= APIClient.getClient().create(APInterface.class);
                Call<ResultRestaurantreview>call= apInterface.getrestreview(resid,uid,review,ratestar);
                call.enqueue(new Callback<ResultRestaurantreview>() {
                    @Override
                    public void onResponse(Call<ResultRestaurantreview> call, Response<ResultRestaurantreview> response) {
                        Toast.makeText(getContext(), "Thanks for Review"
                                , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResultRestaurantreview> call, Throwable t) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        });


    }

   /* private void animateImage(ImageView ratingimage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f, 0, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingimage.startAnimation(scaleAnimation);*//*


    }
*/

}