package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.foodyghar.frag.Home_frag;
import com.example.foodyghar.frag.Profile_frag;
import com.example.foodyghar.frag.Tab_myorder;
import com.example.foodyghar.frag.setting_frg;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homepage extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    ListView listView;
    MeowBottomNavigation bottomNavigation;
    //ProgressBar progressBar;
    SpinKitView spinKitView;
    private long pressedTime;
    private int STORAGE_PERMISSION_CODE = 1;
    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* if (ContextCompat.checkSelfPermission(Homepage.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(Homepage.this, "You have already granted this permission", Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission();
        }*/

        if (Build.VERSION.SDK_INT >= 23) {
            checkMultiplePermissions();
        }


        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.home_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_profile_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.setting));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;

                switch (item.getId()) {
                    case 1:
                        fragment = new Home_frag();
                        loadFragment(fragment, "home");
                        break;

                    case 2:
                        fragment = new Profile_frag();
                        loadFragment(fragment, "profile");
                        break;

                    case 3:
                        fragment = new setting_frg();
                        loadFragment(fragment, "setting");
                        break;
                }
            }
        });

        bottomNavigation.setCount(0, null);

        try {
            Intent i = getIntent();
            if (i.getExtras() == null) {
                bottomNavigation.show(1, true);
            } else {
                String load = i.getStringExtra("load");
                if (load.equals("load")) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout, new Tab_myorder())
                            .addToBackStack("hoteldetail")
                            .commit();
                } else {

                }
            }
        } catch (Exception e) {

        }

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

                /*     progressBar = findViewById(R.id.spin_kit);*/
                spinKitView = findViewById(R.id.spin_kit);
               /* Sprite doubleBounce = new DoubleBounce();
                progressBar.setIndeterminateDrawable(doubleBounce);*/
              /*  Toast.makeText(getApplicationContext(), "You Clicked"+item.getId()
                        , Toast.LENGTH_SHORT).show();*/
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                /*Toast.makeText(getApplicationContext(), "You Reselect"+item.getId()
                        , Toast.LENGTH_SHORT).show();*/
                Fragment fragment = null;

                switch (item.getId()) {
                    case 1:
                        fragment = new Home_frag();
                        loadFragment(fragment, "home");
                        break;

                    case 2:
                        fragment = new Profile_frag();
                        loadFragment(fragment, "profile");
                        break;

                    case 3:
                        fragment = new setting_frg();
                        loadFragment(fragment, "setting");
                        break;
                }
            }
        });

    }

    private void loadFragment(Fragment fragment, String name) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .addToBackStack(name)
                .commit();
    }

    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            try {
                super.onBackPressed();
                finish();
            }catch (Exception e){

            }
        } else {
//            startActivity(new Intent(Homepage.this,Homepage.class));
//            finish();
            try {
                Home_frag home_frag = new Home_frag();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, home_frag);
                ft.commit();
                Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {

            }
        }
        pressedTime = System.currentTimeMillis();
    }
        /*if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            new AlertDialog.Builder(Homepage.this)
                    .setTitle("Exit")
                    .setMessage("Are you Sure ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .show();
        }*/


    private void checkMultiplePermissions() {

        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissionsNeeded = new ArrayList<String>();
            List<String> permissionsList = new ArrayList<String>();

            if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                permissionsNeeded.add("GPS");
            }

            if (!addPermission(permissionsList, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                permissionsNeeded.add("Read Storage");
            }

            if (!addPermission(permissionsList, Manifest.permission.CALL_PHONE)) {
                permissionsNeeded.add("Read Call");
            }

            if (!addPermission(permissionsList, Manifest.permission.READ_CONTACTS)) {
                permissionsNeeded.add("Read Contacts");
            }


            if (!addPermission(permissionsList, Manifest.permission.READ_SMS)) {
                permissionsNeeded.add("Read SMS");
            }

            if (permissionsList.size() > 0) {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                return;
            }
        }
    }


    private boolean addPermission(List<String> permissionsList, String permission) {
        if (Build.VERSION.SDK_INT >= 23)

            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);

                // Check for Rationale Option
                if (!shouldShowRequestPermissionRationale(permission))
                    return false;
            }
        return true;
    }

    /*private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(Homepage.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
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
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }*/


   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE)
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }

    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(android.Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.CALL_PHONE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_CONTACTS, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_SMS, PackageManager.PERMISSION_GRANTED);

                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED){
                    // All Permissions Granted
                    return;
                } else {
                    // Permission Denied
                    if (Build.VERSION.SDK_INT >= 23) {
                        Toast.makeText(
                                getApplicationContext(),
                                "My App cannot run without Location and Storage " +
                                        "Permissions.\nRelaunch My App or allow permissions" +
                                        " in Applications Settings",
                                Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}