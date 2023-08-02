
package com.example.foodyghar.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetImage {

    @SerializedName("getImages")
    @Expose
    private List<GetImage__1> getImages = null;

    public List<GetImage__1> getGetImages() {
        return getImages;
    }

    public void setGetImages(List<GetImage__1> getImages) {
        this.getImages = getImages;
    }

}
