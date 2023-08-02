
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resultfoodmenu {

    @SerializedName("foodmenuCategory")
    @Expose
    private List<FoodmenuCategory> foodmenuCategory = null;

    public List<FoodmenuCategory> getFoodmenuCategory() {
        return foodmenuCategory;
    }

    public void setFoodmenuCategory(List<FoodmenuCategory> foodmenuCategory) {
        this.foodmenuCategory = foodmenuCategory;
    }

}
