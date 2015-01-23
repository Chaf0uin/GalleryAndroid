package com.kerboocorp.galleryandroid.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.kerboocorp.galleryandroid.R;
import com.kerboocorp.galleryandroid.adapters.AlbumAdapter;
import com.kerboocorp.galleryandroid.model.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


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

        List<Album> albumList = new ArrayList<Album>();

        Album album = new Album();
        albumList.add(album);

        album = new Album();
        albumList.add(album);

        album = new Album();
        albumList.add(album);

        album = new Album();
        albumList.add(album);

        album = new Album();
        albumList.add(album);

        album = new Album();
        albumList.add(album);

        albumAdapter.addAlbumList(albumList);

        progressLayout.setVisibility(View.GONE);
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
