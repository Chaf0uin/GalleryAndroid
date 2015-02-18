package com.kerboocorp.galleryandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fmsirvent.ParallaxEverywhere.PEWImageView;
import com.kerboocorp.galleryandroid.R;
import com.kerboocorp.galleryandroid.activities.AlbumActivity;
import com.kerboocorp.galleryandroid.model.Album;
import com.kerboocorp.galleryandroid.utilities.Parameters;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by cgo on 23/01/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Album> albumList;
    private int rowLayout;
    private Context context;

    public AlbumAdapter(int rowLayout, Context context) {
        this.albumList = new ArrayList<Album>();
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void addAlbumList(List<Album> postList) {
        this.albumList.addAll(postList);
        notifyDataSetChanged();
    }

    public void addAlbum(Album album) {
        albumList.add(album);
        notifyDataSetChanged();
    }

    public void removeAlbum(Album album) {
        albumList.remove(album);
        notifyDataSetChanged();
    }


    public void clearAlbumList() {
        albumList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (albumList == null ? 0 : albumList.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new AlbumViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof AlbumViewHolder) {

            final AlbumViewHolder albumViewHolder = (AlbumViewHolder) viewHolder;
            Album album = albumList.get(i);

            albumViewHolder.titleTextView.setText(album.getName());

            String url = Parameters.baseURL + album.getToken();
            Log.d("TEST", url);

            Picasso.with(context).load(Parameters.baseURL + album.getToken()).into(albumViewHolder.albumImageView);

        }

    }


    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
//        public ImageView albumImageView;
        public PEWImageView albumImageView;
        public TextView titleTextView;

        public AlbumViewHolder(View itemView) {
            super(itemView);

            albumImageView = ButterKnife.findById(itemView, R.id.albumImageView);
            titleTextView = ButterKnife.findById(itemView, R.id.titleTextView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, AlbumActivity.class);
            intent.putExtra("albumId", 1);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            context.startActivity(intent);
        }
    }
}