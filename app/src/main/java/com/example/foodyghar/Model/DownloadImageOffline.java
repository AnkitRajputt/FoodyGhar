package com.example.foodyghar.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class DownloadImageOffline extends AsyncTask<String, Void, Bitmap> {

    Context context;
    ImageView offline_image_store;

    public DownloadImageOffline(Context context, ImageView offline_image_store) {
        this.context = context;
        this.offline_image_store = offline_image_store;
    }

    /*
        doInBackground(Params... params)
            Override this method to perform a computation on a background thread.
     */
    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap logo = null;
        try {
            InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
            logo = BitmapFactory.decodeStream(is);
        } catch (Exception e) { // Catch the download exception
            e.printStackTrace();
        }
        return logo;
    }

    /*
        onPostExecute(Result result)
            Runs on the UI thread after doInBackground(Params...).
     */
    protected void onPostExecute(Bitmap result) {
        offline_image_store.setImageBitmap(result);
    }

}