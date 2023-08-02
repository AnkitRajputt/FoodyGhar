package com.example.foodyghar.frag;

import static android.content.Context.CONNECTIVITY_SERVICE;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodyghar.Adapter.RVAdapter;
import com.example.foodyghar.Homepage;
import com.example.foodyghar.Login;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.Model.ResultRestaurantcategory;
import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.User;
import com.example.foodyghar.R;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_frag extends Fragment {

    ArrayList<RestaurantCategory> arrayList;
    RecyclerView rv;
    RVAdapter rvAdapter;
    SpinKitView spinKitView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_home, null);
        rv=v.findViewById(R.id.rcv_user);
        spinKitView=v.findViewById(R.id.spin_kitforhomefragment);
        arrayList= new ArrayList<>();

        Homepage.toolbar.setVisibility(View.VISIBLE);

        spinKitView.setVisibility(View.VISIBLE);

        getActivity().setTitle("Search Hotel");
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        setHasOptionsMenu(true);
        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<ResultRestaurantcategory> call = apInterface.getrestaurantcategory();
        call.enqueue(new Callback<ResultRestaurantcategory>() {
            @Override
            public void onResponse(Call<ResultRestaurantcategory> call, Response<ResultRestaurantcategory> response) {
                arrayList= (ArrayList<RestaurantCategory>) response.body().getRestaurantCategory();
                rvAdapter= new RVAdapter(getActivity(), arrayList);
                rv.setAdapter(rvAdapter);
                spinKitView.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ResultRestaurantcategory> call, Throwable t) {
                spinKitView.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Not responding", Toast.LENGTH_SHORT).show();
            }

        });

        if (!isConnected(Home_frag.this)) {
            Dialog dialog = new Dialog(getActivity(), R.style.NointernetDialog);
            dialog.setContentView(R.layout.no_internet_dialog);
            Button btn_retryinternet;
            btn_retryinternet = dialog.findViewById(R.id.btn_retryinternet);
            btn_retryinternet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isConnected(Home_frag.this))
                    {
                        dialog.dismiss();
                    }
                    else {
                        Toast.makeText(getActivity(), "Please Connect your Mobile with Network", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });

            dialog.show();
        }
        //till here internet
        return v;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater i) {
        super.onCreateOptionsMenu(menu, i);

        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem menuItem= menu.findItem(R.id.app_bar_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setIconified(false);
        searchView.setQueryHint(Html.fromHtml("<font color = #74BDB9B8>" + getResources().getString(R.string.search_hint) + "</font>"));
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("newText1", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("newText", newText);
                rvAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    public boolean isConnected(Home_frag home_frag) {

        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifiConn != null && wifiConn.isConnected() || (mobileConn != null && mobileConn.isConnected()))) {
            return true;
        } else {
            return false;
        }
    }
}
