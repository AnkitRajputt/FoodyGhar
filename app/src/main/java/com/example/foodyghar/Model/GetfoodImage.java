
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetfoodImage {

    @SerializedName("foodimg_id")
    @Expose
    private String foodimgId;
    @SerializedName("foodimg")
    @Expose
    private String foodimg;
    @SerializedName("res_id")
    @Expose
    private String resId;
    @SerializedName("foodimgheader")
    @Expose
    private String foodimgheader;
    @SerializedName("foodimgslider")
    @Expose
    private String foodimgslider;

    public String getFoodimgId() {
        return foodimgId;
    }

    public void setFoodimgId(String foodimgId) {
        this.foodimgId = foodimgId;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getFoodimgheader() {
        return foodimgheader;
    }

    public void setFoodimgheader(String foodimgheader) {
        this.foodimgheader = foodimgheader;
    }

    public String getFoodimgslider() {
        return foodimgslider;
    }

    public void setFoodimgslider(String foodimgslider) {
        this.foodimgslider = foodimgslider;
    }

}
