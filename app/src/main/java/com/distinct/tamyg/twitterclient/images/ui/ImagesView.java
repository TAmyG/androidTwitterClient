package com.distinct.tamyg.twitterclient.images.ui;

import com.distinct.tamyg.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by tamyg on 20/06/16.
 */
public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
