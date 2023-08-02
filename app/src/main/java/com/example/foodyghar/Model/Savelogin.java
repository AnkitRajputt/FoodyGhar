
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Savelogin {

    @SerializedName("u_id")
    @Expose
    private String uId;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("imgname")
    @Expose
    private String imgname;
    @SerializedName("img")
    @Expose
    private String img;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
