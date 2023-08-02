
package com.example.foodyghar.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultRestaurantcategory {

    @SerializedName("RestaurantCategory")
    @Expose
    private List<RestaurantCategory> restaurantCategory = null;

    public List<RestaurantCategory> getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(List<RestaurantCategory> restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

}
