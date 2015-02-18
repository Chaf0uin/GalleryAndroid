package com.kerboocorp.galleryandroid.model;

import com.google.gson.annotations.Expose;

/**
 * Created by cgo on 23/01/2015.
 */
public class BaseModel {

    @Expose
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
