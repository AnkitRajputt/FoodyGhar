
package com.example.foodyghar.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultlogin {

    @SerializedName("savelogin")
    @Expose
    private List<Savelogin> savelogin = null;

    public List<Savelogin> getSavelogin() {
        return savelogin;
    }

    public void setSavelogin(List<Savelogin> savelogin) {
        this.savelogin = savelogin;
    }

}
