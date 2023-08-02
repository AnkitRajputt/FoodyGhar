
package com.example.foodyghar.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultRestaurantreview {

    @SerializedName("Restaurantreview")
    @Expose
    private List<Restaurantreview> restaurantreview = null;

    public List<Restaurantreview> getRestaurantreview() {
        return restaurantreview;
    }

    public void setRestaurantreview(List<Restaurantreview> restaurantreview) {
        this.restaurantreview = restaurantreview;
    }

}
