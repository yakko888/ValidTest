package co.personal.validtest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Topartists implements Serializable {

    @SerializedName("artist")
    private List<Artist> artist;
    @SerializedName("@attr")
    private Attr attr;

    public Topartists(List<Artist> artist, Attr attr) {
        this.artist = artist;
        this.attr = attr;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}
