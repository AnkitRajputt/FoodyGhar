
package com.example.foodyghar.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Resultbookslot {

    @SerializedName("bookslot")
    @Expose
    private List<Bookslot> bookslot = null;

    public List<Bookslot> getBookslot() {
        return bookslot;
    }

    public void setBookslot(List<Bookslot> bookslot) {
        this.bookslot = bookslot;
    }

}
