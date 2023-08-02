package com.example.foodyghar.frag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodyghar.Homepage;
import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.R;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.example.foodyghar.Webservice.ServerResponse;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Profile_frag extends Fragment {

    CircleImageView pickimg;
    ImageView  procamera;
    String uridata;
    Button btnupdate;
    SpinKitView spinKitView;
    File destination;
    String ID;
    TextView profun,proemail;
    EditText prousername,prouserlastname, promobno, prousereml;
    ArrayList<Savelogin>arrayList;


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_frag, container, false);
        Homepage.toolbar.setVisibility(View.GONE);

        setHasOptionsMenu(false);


        spinKitView=v.findViewById(R.id.spin_kitforprofilefragment);
        pickimg = v.findViewById(R.id.proimg);
        procamera = v.findViewById(R.id.prpofilecamera);
        profun= v.findViewById(R.id.profun);
        proemail= v.findViewById(R.id.proemail);
        prousername= v.findViewById(R.id.prousername);
        prouserlastname=v.findViewById(R.id.prouserlastname);
        promobno= v.findViewById(R.id.promobno);
        prousereml= v.findViewById(R.id.prousereml);
        btnupdate=v.findViewById(R.id.btnupdate);
        arrayList=new ArrayList<>();
        spinKitView.setVisibility(View.VISIBLE);

        SharedPreferences pref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String uid = pref.getString("uid", null);
        ID= pref.getString("uid", null);
        String un = pref.getString("firstname", null);
        String fname = pref.getString("firstname", null);
        String lname = pref.getString("lastname",null);
        String contac = pref.getString("contact", null);
        String eml = pref.getString("emailid", null);
        String eml2 = pref.getString("emailid", null);
        String img = pref.getString("img", null);

        try{
            Picasso.get().load(img).into(pickimg);
            spinKitView.setVisibility(View.INVISIBLE);
            Log.e("IMG",img);
        }catch (Exception e)
        {
            //Log.e("IMG",img);
        }
        profun.setText(un);
        prousername.setText(fname);
        prouserlastname.setText(lname);
        promobno.setText(contac);
        proemail.setText(eml);
        prousereml.setText(eml2);



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String N1=prousername.getText().toString();
                String N2=prouserlastname.getText().toString();
                String N3=promobno.getText().toString();
                String N4=prousereml.getText().toString();

                APInterface apInterface=APIClient.getClient().create(APInterface.class);
                Call<Resultlogin>call=apInterface.updatepro(uid,N1,N2,N3,N4);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList= (ArrayList<Savelogin>) response.body().getSavelogin();
                        SharedPreferences pref=getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed=pref.edit();
                        ed.putString("eml",arrayList.get(0).getEmailid());
                        ed.putString("password",arrayList.get(0).getPassword());
                        ed.putString("uid",arrayList.get(0).getuId());
                        ed.putString("fname",arrayList.get(0).getFirstname());
                        ed.putString("lname",arrayList.get(0).getLastname());
                        ed.putString("contac",arrayList.get(0).getContact());
                        //ed.putString("img",arrayList.get(0).getImg());
                        ed.putBoolean("isLog",true);
                        ed.apply();
                        prousername.setText(N1);
                        prouserlastname.setText(N2);
                        promobno.setText(N3);
                        prousereml.setText(N4);
                        /*try{
                            Picasso.get().load(img).into(pickimg);
                        }catch (Exception e)
                        {
                            Log.e("img",img);
                        }*/

                        Toast.makeText(getActivity(), "Update Successfully", Toast.LENGTH_SHORT).show();
                        spinKitView.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {

                        Toast.makeText(getActivity(), "Please input correct details", Toast.LENGTH_SHORT).show();
                        spinKitView.setVisibility(View.INVISIBLE);
                    }
                });

            }


        });

        procamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });

       /* procamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 101);

            }
        });*/

        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {
                Uri uri = data.getData();
                pickimg.setImageURI(uri);
                String[] filePathcolumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(uri, filePathcolumn, null, null, null);
                cursor.moveToFirst();
                int clumnIndex = cursor.getColumnIndex(filePathcolumn[0]);
                uridata = cursor.getString(clumnIndex);
                uploadimage(uridata);
                Log.e("IMGPATH", uridata);
            }
            catch(Exception e)
            {

            }
        } else if (requestCode == 101) {
            if (requestCode == 101 && resultCode == getActivity().RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                pickimg.setImageBitmap(photo);
                uploadimage(uridata);
            }
        }

    }

    public void uploadimage(String uridata) {
        try {

            Map<String, RequestBody> map = new HashMap<>();
            File file = new File(uridata);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part fileupload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
            RequestBody imgname = RequestBody.create(MediaType.parse("text/plain"), "myimage");
            RequestBody id = RequestBody.create(MediaType.parse("text/plain"), ID);

            APInterface apInterface = APIClient.getClient().create(APInterface.class);
            Call<Resultlogin> call = apInterface.postimage(fileupload,imgname,id);
            call.enqueue(new Callback<Resultlogin>() {
                @Override
                public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                   // spinKitView.setVisibility(View.GONE);

                    try {
                        arrayList= (ArrayList<Savelogin>) response.body().getSavelogin();
                        SharedPreferences pref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed = pref.edit();
                        ed.putString("img", arrayList.get(0).getImg());
                        ed.apply();
                        Toast.makeText(getActivity(), "Image Upload", Toast.LENGTH_SHORT).show();
                    }catch (Exception e)
                    {

                    }
                }

                @Override
                public void onFailure(Call<Resultlogin> call, Throwable t) {
                    Log.e("IMG", "Image Not Upload" + t);
                }
            });
        } catch (Exception e) {
            Log.e("Error", String.valueOf(e));
        }
    }

}