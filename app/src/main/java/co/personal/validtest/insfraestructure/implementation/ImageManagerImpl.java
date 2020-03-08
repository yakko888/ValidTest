package co.personal.validtest.insfraestructure.implementation;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.squareup.picasso.Picasso;

import java.util.Map;

import co.personal.validtest.R;
import co.personal.validtest.insfraestructure.interfaces.ImageManagerLocal;

public class ImageManagerImpl implements ImageManagerLocal {

    private Context mContext;

    public ImageManagerImpl(Context context)
    {
        mContext = context;
    }

    public void loadImageWithPicasso(String url, ImageView imageView){
        Picasso.with(mContext)
                .load(url)
                .into(imageView);
    }

    public void loadImage(String url, ImageView imageView)
    {
        Glide.with(mContext)
                .load(url)
                .into(imageView);
    }

    @Override
    public void loadImage(String url, Map<String, String> header, ImageView imageView)
    {
        GlideUrl glideUrl = null;
        if (url != null)
        {
            LazyHeaders.Builder lazyHeadersBuilder = new LazyHeaders.Builder();
            for (String headerKey : header.keySet())
            {
                lazyHeadersBuilder.addHeader(headerKey, header.get(headerKey));
            }

            glideUrl = new GlideUrl(url, lazyHeadersBuilder.build());
        }

        if (url != null)
        {
            Glide.with(mContext)
                    .load(glideUrl)
                    .into(imageView);
        } else
        {
            Glide.with(mContext)
                    .load(url)
                    .into(imageView);
        }
    }

    @Override
    public void loadImage(String url, ImageView imageView, int placeHolderResourceId)
    {
        Glide.with(mContext)
                .load(url)
                .placeholder(placeHolderResourceId)
                .into(imageView);
    }
}
