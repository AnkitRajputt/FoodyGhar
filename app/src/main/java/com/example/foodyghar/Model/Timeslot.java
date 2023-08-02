
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeslot {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sloat")
    @Expose
    private String sloat;
    @SerializedName("resid")
    @Expose
    private String resid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSloat() {
        return sloat;
    }

    public void setSloat(String sloat) {
        this.sloat = sloat;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }

}
