package com.example.foodyghar.Webservice;

import com.example.foodyghar.Model.Getfoodimg;
import com.example.foodyghar.Model.ResultPaymentdetails;
import com.example.foodyghar.Model.ResultRestaurantreview;
import com.example.foodyghar.Model.ResultTimeslot;
import com.example.foodyghar.Model.Resultbookslot;
import com.example.foodyghar.Model.Resultcarttable;
import com.example.foodyghar.Model.GetImage;
import com.example.foodyghar.Model.ResultRestaurantcategory;
import com.example.foodyghar.Model.Resultfoodmenu;
import com.example.foodyghar.Model.Resultlogin;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APInterface {
    @FormUrlEncoded
    @POST("registration.php")
    Call<Resultlogin> insert(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("contact") String contact,
            @Field("emailid") String emailid,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<Resultlogin> login(
            @Field("emailid") String emailid,
            @Field("password") String password);


    @Multipart
    @POST("imgupload.php")
    Call<Resultlogin> postimage(@Part MultipartBody.Part img,
                                @Part("imgname") RequestBody imgname,
                                @Part("u_id") RequestBody id);

    @FormUrlEncoded
    @POST("changepassword.php")
    Call<Resultlogin> update(
            @Field("contact") String contact,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("otplogin.php")
    Call<Resultlogin> otplogin(
            @Field("contact") String contact
    );

    @FormUrlEncoded
    @POST("updateprofile.php")
    Call<Resultlogin> updatepro(
            @Field("u_id") String id,
            //@Field("profileimg") String profileimg,
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("contact") String contact,
            @Field("emailid") String emailid);


    @FormUrlEncoded
    @POST("insertratingapp.php")
    Call<Resultlogin> insertrating(
            @Field("u_id") String id,
            @Field("apprating") float apprating);


    @FormUrlEncoded
    @POST("insertfeedback.php")
    Call<Resultlogin> insertfeedback(
            @Field("u_id") String id,
            @Field("feed_desc") String feed_desc);

    @FormUrlEncoded
    @POST("showresheaderimg.php")
    Call<GetImage> getHeaderImage(
            @Field("res_id") String id);

    @FormUrlEncoded
    @POST("showressliderimg.php")
    Call<GetImage> getSliderImage(
            @Field("res_id") String id);

    @FormUrlEncoded
    @POST("showresallimg.php")
    Call<GetImage> getAllImage(
            @Field("res_id") String id);

    @FormUrlEncoded
    @POST("showcart.php")
    Call<Resultcarttable> showcart(
            @Field("u_id") String id,
            @Field("res_id") String res_id
    );

    @FormUrlEncoded
    @POST("addtocart.php")
    Call<Resultcarttable> addtocart(
            @Field("u_id") String id,
            @Field("food_id") String foodid,
            @Field("res_id") String resid,
            @Field("total_item") String total_item);

    @FormUrlEncoded
    @POST("updatecart.php")
    Call<Resultcarttable> updatecart(
            @Field("u_id") String id,
            @Field("food_id") String foodid,
            @Field("total_item") String total_item,
            @Field("res_id") String resid
    );

    @FormUrlEncoded
    @POST("deletecart.php")
    Call<Resultcarttable> deletecart(
            @Field("cart_id") String id
    );

    @FormUrlEncoded
    @POST("check_cart.php")
    Call<Resultcarttable> check_cart(
            @Field("u_id") String id
    );
    /*@Multipart
    @POST("updateprofile.php")
    Call<Resultlogin> updatefacultydata(@Query("faculty_id") String faculty_id,
                                                      @Query("u_id") String u_id,
                                                      @Query("profileimg") String profileimg,
                                                      @Query("firstname") String firstname,
                                                      @Query("lastname") String lastname,
                                                      @Query("contact") String contact,
                                                      @Query("emailid") String emailid,
                                                      @Part MultipartBody.Part file,
                                                      @Part("faculty_profilepic") RequestBody name);*/

    @GET("showrestauranttbl.php")
    Call<ResultRestaurantcategory> getrestaurantcategory();

    @FormUrlEncoded
    @POST("showfoodmenu.php")
    Call<Resultfoodmenu> getFoodmenuCategory(
            @Field("resfoodtable") String resfoodtable);

    @FormUrlEncoded
    @POST("showfoodlayout.php")
    Call<Resultfoodmenu> getFoodmenulayout(
            @Field("resfoodtable") String resfoodtable);


    @FormUrlEncoded
    @POST("showfoodsliderimg.php")
    Call<Getfoodimg> getFoodSliderImage(
            @Field("res_id") String id);

    @FormUrlEncoded
    @POST("showslot.php")
    Call<ResultTimeslot> gettimeslot(
            @Field("resid") String id);

    @FormUrlEncoded
    @POST("bookslot.php")
    Call<Resultbookslot> bookslot(
            @Field("bookdate") String bookdate,
            @Field("totalbookmber") String totalbookmber,
            @Field("timslot") String timslot,
            @Field("slotname") String slotname,
            @Field("slotemail") String slotemail,
            @Field("slotmobile") String slotmobile,
            @Field("uid") String uid,
            @Field("resid") String resid,
            @Field("bookid") String bookid
    );

    @FormUrlEncoded
    @POST("showreview.php")
    Call<ResultRestaurantreview> showrestreview(
            @Field("res_id") String resid
           /* @Field("rev_desc") String revdesc,
            @Field("rating") float rating*/
    );

    @FormUrlEncoded
    @POST("restreview.php")
    Call<ResultRestaurantreview> getrestreview(
            @Field("res_id") String resid,
            @Field("u_id") String uid,
            @Field("rev_desc") String revdesc,
            @Field("rating") float rating
    );

    @FormUrlEncoded
    @POST("payment.php")
    Call<ResultPaymentdetails> getpaymentdetail(
            @Field("res_id") int resid,
            @Field("u_id") int uid,
            @Field("book_id") int bookid,
            @Field("cart_id") int cartid,
            @Field("amount") String amount,
            @Field("menuamt") String menuamt,
            @Field("status") String status,
            @Field("preorder") String preorde
    );

    @FormUrlEncoded
    @POST("showmyorder.php")
    Call<Resultcarttable> showmyorder(
            @Field("u_id") String id
    );


    /*@FormUrlEncoded
    @POST("payment.php")
    Call<ResultPaymentdetails> getmenupaymentdetail(
            @Field("res_id") String resid,
            @Field("u_id") String uid,
            @Field("book_id") String bookid,
            @Field("cart_id") String cartid,
            @Field("pay_date") String pay_date,
            @Field("menuamt") String menuamt,
            @Field("status") String status
    );*/

}
