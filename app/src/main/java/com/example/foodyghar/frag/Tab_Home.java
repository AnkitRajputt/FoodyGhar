package com.example.foodyghar.frag;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Login;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.R;
import com.example.foodyghar.Registration;
import com.example.foodyghar.Tab_Home_booking2;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.Locale;

public class Tab_Home extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    LinearLayout call_to_action_button, call_button_resact, direction_button_resact;
    CardView rating_card_res;
    TextView home_tab_name, home_tab_location, home_tab_rating_text, home_tab_hours,
            home_tab_open_status, home_tab_price,
            call_to_action_button_textview, rating_card_text_res;
    private int READ_CONTACTS_CODE = 100;
    ArrayList<RestaurantCategory> arrayList;
    RatingBar home_tab_ratingbar;
    Homepage homepage;
    String h_con = "", h_location = "";
    ArrayList<Savelogin> saveloginArrayList;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;
    Location mCurrentLocation;
    double lat1 = 0, log1 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_home, null);
        statusCheck();
        homepage = (Homepage) getActivity();
        Homepage.toolbar.setVisibility(View.GONE);
        setHasOptionsMenu(true);

        //Initialising elements
        arrayList = new ArrayList<>();
        saveloginArrayList = new ArrayList<>();
        home_tab_name = v.findViewById(R.id.home_tab_name);
        home_tab_location = v.findViewById(R.id.home_tab_location);
        home_tab_rating_text = v.findViewById(R.id.home_tab_rating_text);
        home_tab_hours = v.findViewById(R.id.home_tab_hours);
        home_tab_open_status = v.findViewById(R.id.home_tab_open_status);
        home_tab_price = v.findViewById(R.id.home_tab_price);
        call_to_action_button_textview = v.findViewById(R.id.call_to_action_button_textview);

        home_tab_ratingbar = v.findViewById(R.id.home_tab_ratingbar);
        call_button_resact = v.findViewById(R.id.call_button_resact);
        direction_button_resact = v.findViewById(R.id.direction_button_resact);
        call_to_action_button = v.findViewById(R.id.call_to_action_button);
        rating_card_text_res = v.findViewById(R.id.rating_card_text_res);
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();


        SharedPreferences pref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String h_id = pref.getString("hotel_id", null);
        String h_name = pref.getString("hotel_name", null);
        String h_address = pref.getString("hotel_add", null);
        String h_cost = pref.getString("hotel_cost", null);
        h_con = pref.getString("rescontact", null);
        h_location = pref.getString("hotel_location", null);
        String h_rate = pref.getString("hotel_rate", null);
        String h_hours = pref.getString("hotel_hours", null);

        home_tab_name.setText(h_name);
        home_tab_location.setText(h_address);
        home_tab_price.setText(h_cost + " per booking");
        home_tab_rating_text.setText(h_rate + " Flipstars");
        rating_card_text_res.setText(h_rate);
        home_tab_hours.setText(h_hours);
        home_tab_ratingbar.setRating(Float.parseFloat(h_rate));

        call_button_resact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, READ_CONTACTS_CODE);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + h_con));
                        startActivity(intent);
                    }
                } catch (Exception e) {

                }
            }
        });

        direction_button_resact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Geocoder geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
                    ArrayList<Address> addresses = (ArrayList<Address>) geocoder.getFromLocationName(h_location, 1);
                    String fulladdres = addresses.get(0).getAddressLine(0);
                    Log.e("Address", fulladdres);
                    double lat = addresses.get(0).getLatitude();
                    double log = addresses.get(0).getLongitude();
                    Log.e("LAT_LOG", lat + ":" + log);
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=" + lat1 + "," + log1 + "&daddr=" + lat + "," + log));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                }

            }
        });
        call_to_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                boolean b = pref.getBoolean("skip", false);
                if (b) {
                    Intent intent = new Intent(getActivity().getApplication(), Tab_Home_booking2.class);
               /* String hotel_id = arrayList.get(0).getId();
                String hotel_name=arrayList.get(1).getName();*/
                    //String hotel_id = ""+getString().toString();
                    String hotel_name = home_tab_name.getText().toString();

               /* SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("hotel_id", hotel_id);
                editor.putString("hotel_name", hotel_name);
                editor.apply();*/
                    intent.putExtra("hotel_name", hotel_name);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Need to Signup or login")
                            .setMessage("Please Select Option")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getActivity().getApplication(), Login.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                }
                            }).show();

                }

            }


        });

        // Set Rating
       /* CardView ratingCard = (CardView)v.findViewById(R.id.rating_card_res);
        activeSpot;
        ((TextView)v.findViewById(R.id.rating_card_text_res)).setText(activeSpot.getSpotRating());
        float rating = Float.parseFloat(activeSpot.getSpotRating());
        if (rating >= 4.5){
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        }else if (rating >= 4){
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }else if (rating >= 3){
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        }else if (rating >= 2){
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
        }else if (rating >= 1){
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }else{
            ratingCard.setCardBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }*/


        return v;

    }

    /*private void requestStoragePermission2() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, READ_CONTACTS_CODE);
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + h_con));
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, READ_CONTACTS_CODE);
        }
    }*/


    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_CONTACTS_CODE)
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        try {
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            lat1 = mCurrentLocation.getLatitude();
            log1 = mCurrentLocation.getLongitude();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        lat1 = location.getLatitude();
        log1 = location.getLongitude();
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}