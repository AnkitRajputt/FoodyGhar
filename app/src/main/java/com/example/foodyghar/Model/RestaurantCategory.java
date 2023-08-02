
package com.example.foodyghar.Model;


import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class RestaurantCategory implements Serializable{

    @SerializedName("res_id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("tbl_cost")
    @Expose
    private String tblcost;
    @SerializedName("res_rate")
    @Expose
    private String resrate;
    @SerializedName("res_location")
    @Expose
    private String reslocation;
    @SerializedName("tbl_date")
    @Expose
    private String tbldate;
    @SerializedName("foodies")
    @Expose
    private String foodies;
    @SerializedName("res_contact")
    @Expose
    private String rescontact;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("res_image")
    @Expose
    private String res_image;

    public String getImage() {
        return image;
    }

    public String getRes_image() {
        return res_image;
    }

    public void setRes_image(String res_image) {
        this.res_image = res_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address; }

    public String getTblcost() {
        return tblcost;
    }

    public void setTblcost(String tblcost) {
        this.tblcost = tblcost;
    }

    public String getResrate(){ return resrate; }

    public void setResrate(String resrate) { this.resrate=resrate; }

    public String getReslocation() {
        return reslocation;
    }

    public void setReslocation(String reslocation) {
        this.reslocation = reslocation;
    }

    public String getTbldate() {
        return tbldate;
    }

    public void setTbldate(String tbldate) {
        this.tbldate = tbldate;
    }

    public String getFoodies() {
        return foodies;
    }

    public void setFoodies(String foodies) {
        this.foodies = foodies;
    }

    public String getRescontact() {
        return rescontact;
    }

    public void setRescontact(String rescontact) {
        this.rescontact = rescontact;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

}
