package com.distinct.tamyg.twitterclient.images.events;

import com.distinct.tamyg.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by tamyg on 20/06/16.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
