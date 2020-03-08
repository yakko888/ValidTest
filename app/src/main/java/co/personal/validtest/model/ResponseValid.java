package co.personal.validtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseValid implements Serializable {

    @SerializedName("topartists")
    @Expose
    private Topartists topartists;

    public Topartists getTopartists() {
        return topartists;
    }

    public ResponseValid(Topartists topartists) {
        this.topartists = topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }
}
