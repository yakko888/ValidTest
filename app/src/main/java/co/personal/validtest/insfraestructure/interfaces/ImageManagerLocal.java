package co.personal.validtest.insfraestructure.interfaces;

import android.widget.ImageView;

import java.util.Map;

public interface ImageManagerLocal {

    void loadImage(String url, ImageView imageView);

    void loadImage(String url, Map<String, String> header, ImageView imageView);

    void loadImage(String url, ImageView imageView, int placeHolderResourceId);
}
