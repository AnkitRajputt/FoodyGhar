
package com.example.foodyghar.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Bookslot {

    @SerializedName("bookid")
    @Expose
    private String bookid;
    @SerializedName("bookdate")
    @Expose
    private String bookdate;
    @SerializedName("totalbookmber")
    @Expose
    private String totalbookmber;
    @SerializedName("timslot")
    @Expose
    private String timslot;
    @SerializedName("slotname")
    @Expose
    private String slotname;
    @SerializedName("slotemail")
    @Expose
    private String slotemail;
    @SerializedName("slotmobile")
    @Expose
    private String slotmobile;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("resid")
    @Expose
    private String resid;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
    }

    public String getTotalbookmber() {
        return totalbookmber;
    }

    public void setTotalbookmber(String totalbookmber) {
        this.totalbookmber = totalbookmber;
    }

    public String getTimslot() {
        return timslot;
    }

    public void setTimslot(String timslot) {
        this.timslot = timslot;
    }

    public String getSlotname() {
        return slotname;
    }

    public void setSlotname(String slotname) {
        this.slotname = slotname;
    }

    public String getSlotemail() {
        return slotemail;
    }

    public void setSlotemail(String slotemail) {
        this.slotemail = slotemail;
    }

    public String getSlotmobile() {
        return slotmobile;
    }

    public void setSlotmobile(String slotmobile) {
        this.slotmobile = slotmobile;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }

}
