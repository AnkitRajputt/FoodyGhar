
package com.example.foodyghar.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Restaurantreview {

    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("rev_desc")
    @Expose
    private String revDesc;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;

    @SerializedName("u_id")
    @Expose
    private String u_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRevDesc() {
        return revDesc;
    }

    public void setRevDesc(String revDesc) {
        this.revDesc = revDesc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
