
package com.example.foodyghar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Getfoodimg {

    @SerializedName("getfoodImages")
    @Expose
    private List<GetfoodImage> getfoodImages = null;

    public List<GetfoodImage> getGetfoodImages() {
        return getfoodImages;
    }

    public void setGetfoodImages(List<GetfoodImage> getfoodImages) {
        this.getfoodImages = getfoodImages;
    }

}
