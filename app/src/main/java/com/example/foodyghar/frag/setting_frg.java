package com.example.foodyghar.frag;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;

import com.example.foodyghar.Adapter.settingadapter;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Login;
import com.example.foodyghar.Model.SettingModel;
import com.example.foodyghar.R;

import java.util.ArrayList;


public class setting_frg extends Fragment {
    /*private Switch aSwitch;

    public static final String MyPREFRENCES = "nightModeprefe";
    public static final String KEY_ISNIGHTMODE = "isnightmode";
    SharedPreferences sharedPreferences;
*/
    RecyclerView recyclerView;
    ArrayList<SettingModel> arrayList;
    Homepage homepage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_frg, container, false);
        homepage = (Homepage) getActivity();
        Homepage.toolbar.setVisibility(View.GONE);
       /* getActivity().setTitle("Setting");
        setHasOptionsMenu(true);*/

/*
        sharedPreferences = homepage.getSharedPreferences(MyPREFRENCES, Context.MODE_PRIVATE);

        aSwitch = view.findViewById(R.id.switch1);

        checkNightModeActivated();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    savedNightModestate(true);
                    homepage.recreate();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    savedNightModestate(false);
                    homepage.recreate();
                }

            }
        });
*/

        recyclerView = view.findViewById(R.id.rcvview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();


        SettingModel ad0 = new SettingModel(R.drawable.appinfo_icon, "App Info");
        arrayList.add(ad0);

        SettingModel ad1 = new SettingModel(R.drawable.tc_icon, "T&C");
        arrayList.add(ad1);

        SettingModel ad2 = new SettingModel(R.drawable.feedback_icon, "Rate us");
        arrayList.add(ad2);

        SettingModel ad3 = new SettingModel(R.drawable.app_permission, "App Permission");
        arrayList.add(ad3);

        SettingModel ad4 = new SettingModel(R.drawable.help_icon, "FAQ");
        arrayList.add(ad4);

        SettingModel ad5 = new SettingModel(R.drawable.contactus, "Contact us? Need Help?");
        arrayList.add(ad5);

        SettingModel ad6 = new SettingModel(R.drawable.ic_bx_share_alt_1, "Share App");
        arrayList.add(ad6);

        SettingModel ad7 = new SettingModel(R.drawable.logout_icon, "Logout");
        arrayList.add(ad7);

        SettingModel ad8 = new SettingModel(R.drawable.exit_icon, "Exit");
        arrayList.add(ad8);


        recyclerView.setAdapter(new settingadapter(arrayList, getActivity()));

        return view;

    }

   /* private void savedNightModestate(boolean nightMode) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(KEY_ISNIGHTMODE,nightMode);
        editor.apply();
    }

    public void checkNightModeActivated(){
        if (sharedPreferences.getBoolean(KEY_ISNIGHTMODE,false)) {
            aSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            aSwitch.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }*/
}







