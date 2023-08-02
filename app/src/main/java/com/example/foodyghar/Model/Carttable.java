
package com.example.foodyghar.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Carttable {

    @SerializedName("food_id")
    @Expose
    private String foodId;
    @SerializedName("res_id")
    @Expose
    private String resId;
    @SerializedName("foodname")
    @Expose
    private String foodname;
    @SerializedName("foodprice")
    @Expose
    private String foodprice;
    @SerializedName("food_img")
    @Expose
    private String foodImg;
    @SerializedName("cart_id")
    @Expose
    private String cartId;
    @SerializedName("u_id")
    @Expose
    private String uId;
    @SerializedName("total_item")
    @Expose
    private int total_item;

    public int getTotal_item() {
        return total_item;
    }

    public void setTotal_item(int total_item) {
        this.total_item = total_item;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
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

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

}
