package com.kerboocorp.galleryandroid.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.kerboocorp.galleryandroid.R;
import com.kerboocorp.galleryandroid.adapters.AlbumAdapter;
import com.kerboocorp.galleryandroid.managers.AlbumManager;
import com.kerboocorp.galleryandroid.managers.services.AlbumService;
import com.kerboocorp.galleryandroid.model.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.albumList) RecyclerView albumListView;
    @InjectView(R.id.progressLayout) RelativeLayout progressLayout;

    private LinearLayoutManager linearLayoutManager;
    private AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        toolbar.setTitle(R.string.app_name_display);
        setSupportActionBar(toolbar);

        linearLayoutManager = new LinearLayoutManager(this);
        albumListView.setLayoutManager(linearLayoutManager);
        albumListView.setItemAnimator(new DefaultItemAnimator());

        albumAdapter = new AlbumAdapter(R.layout.list_item_album, this);
        albumListView.setAdapter(albumAdapter);


        AlbumManager.getAlbumService().findAlbumList(new Callback<List<Album>>() {
            @Override
            public void success(List<Album> albums, Response response) {
                Log.d("TEST", "OKEEE");
                albumAdapter.addAlbumList(albums);
                progressLayout.setVisibility(View.GONE);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TEST", "OH NEEEEE");
                progressLayout.setVisibility(View.GONE);

            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
