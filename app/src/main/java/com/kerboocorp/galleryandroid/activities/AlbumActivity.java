package com.kerboocorp.galleryandroid.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.kerboocorp.galleryandroid.R;
import com.kerboocorp.galleryandroid.adapters.AlbumAdapter;
import com.kerboocorp.galleryandroid.model.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by cgo on 23/01/2015.
 */
public class AlbumActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.progressLayout) RelativeLayout progressLayout;
    @InjectView(R.id.photoGridView) GridView photoGridView;

    private Long albumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        ButterKnife.inject(this);

        albumId = getIntent().getLongExtra("albumId", -1);

        toolbar.setTitle("Lalalal " + String.valueOf(albumId));
        setSupportActionBar(toolbar);

        progressLayout.setVisibility(View.GONE);
    }
}
