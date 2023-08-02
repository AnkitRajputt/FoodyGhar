
package com.example.foodyghar.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultPaymentdetails {

    @SerializedName("paymentdetails")
    @Expose
    private List<Paymentdetail> paymentdetails = null;

    public List<Paymentdetail> getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(List<Paymentdetail> paymentdetails) {
        this.paymentdetails = paymentdetails;
    }

}
