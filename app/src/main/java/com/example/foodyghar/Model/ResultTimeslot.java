
package com.example.foodyghar.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultTimeslot {

    @SerializedName("timeslot")
    @Expose
    private List<Timeslot> timeslot = null;

    public List<Timeslot> getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(List<Timeslot> timeslot) {
        this.timeslot = timeslot;
    }

}
