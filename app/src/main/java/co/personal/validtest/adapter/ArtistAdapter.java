package co.personal.validtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import co.personal.validtest.R;
import co.personal.validtest.model.Artist;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    private List mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public ArtistAdapter(Context context, List<Artist> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rv_listartist, parent, false);
        return new ArtistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtistAdapter.ViewHolder holder, int position) {

        Artist artistitem = (Artist) mData.get(position);

        try {
            holder.item_name.setText(artistitem.getName());
            holder.item_url.setText(artistitem.getUrl());
            Linkify.addLinks(holder.item_url, Linkify.WEB_URLS);

            final ImageView imageView = holder.item_image;
            String imageURL = artistitem.getUrl();

            Picasso.with(mContext)
                    .load(R.drawable.img_empty)
                    .centerInside()
                    .into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    Log.d("TAG", "onSuccess");
                }

                @Override
                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name;
        TextView item_url;

        public ViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_name = (TextView)itemView.findViewById(R.id.txvartist);
            item_url = (TextView)itemView.findViewById(R.id.txvurl);
        }
    }
}
