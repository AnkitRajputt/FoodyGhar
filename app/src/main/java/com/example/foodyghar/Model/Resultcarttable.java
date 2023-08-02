
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Resultcarttable {

    @SerializedName("carttable")
    @Expose
    private List<Carttable> carttable = null;

    public List<Carttable> getCarttable() {
        return carttable;
    }

    public void setCarttable(List<Carttable> carttable) {
        this.carttable = carttable;
    }

}
