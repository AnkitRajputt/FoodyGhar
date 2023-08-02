
package com.example.foodyghar.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetImage__1 {

    @SerializedName("resimg_id")
    @Expose
    private String resimgId;
    @SerializedName("resimg")
    @Expose
    private String resimg;
    @SerializedName("res_id")
    @Expose
    private String resId;
    @SerializedName("imgheader")
    @Expose
    private String imgheader;
    @SerializedName("imgslider")
    @Expose
    private String imgslider;

    public String getResimgId() {
        return resimgId;
    }

    public void setResimgId(String resimgId) {
        this.resimgId = resimgId;
    }

    public String getResimg() {
        return resimg;
    }

    public void setResimg(String resimg) {
        this.resimg = resimg;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getImgheader() {
        return imgheader;
    }

    public void setImgheader(String imgheader) {
        this.imgheader = imgheader;
    }

    public String getImgslider() {
        return imgslider;
    }

    public void setImgslider(String imgslider) {
        this.imgslider = imgslider;
    }

}
