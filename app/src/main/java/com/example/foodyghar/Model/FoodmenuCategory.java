
package com.example.foodyghar.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FoodmenuCategory {

    @SerializedName("food_id")
    @Expose
    private String foodId;
    @SerializedName("foodname")
    @Expose
    private String foodname;
    @SerializedName("foodprice")
    @Expose
    private String foodprice;
    @SerializedName("food_img")
    @Expose
    private String foodImg;
    @SerializedName("resfoodtable")
    @Expose
    private String resfoodtable;
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public String getResfoodtable() {
        return resfoodtable;
    }

    public void setResfoodtable(String resfoodtable) {
        this.resfoodtable = resfoodtable;
    }
}
