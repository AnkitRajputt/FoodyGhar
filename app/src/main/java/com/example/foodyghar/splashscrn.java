package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;



public class splashscrn extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscrn);
//        getSupportActionBar().hide();
        videoView=findViewById(R.id.videoView);

        try {
            String video_url="android.resource://" + getPackageName() + "/" + R.raw.splash;
            Uri videoUri =Uri.parse(video_url);
            MediaController mediaController=new MediaController(splashscrn.this);
            mediaController.setAnchorView(videoView);
            videoView.setVideoURI(videoUri);
            videoView.requestFocus();
            videoView.start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(splashscrn.this,Login.class));
                    finish();
                }
            }, 3000);


        }catch (Exception e)
        {
        }
    }
}