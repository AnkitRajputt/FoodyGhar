
package com.example.foodyghar.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Paymentdetail {

    @SerializedName("pay_id")
    @Expose
    private String payId;
    @SerializedName("res_id")
    @Expose
    private String resId;
    @SerializedName("u_id")
    @Expose
    private String uId;
    @SerializedName("book_id")
    @Expose
    private String bookId;
    @SerializedName("cart_id")
    @Expose
    private String cartId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("menuamt")
    @Expose
    private String menuamt;
    @SerializedName("pay_date")
    @Expose
    private String payDate;
    @SerializedName("status")
    @Expose
    private String status;


    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMenuamt() {
        return menuamt;
    }

    public void setMenuamt(String menuamt) {
        this.menuamt = menuamt;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
