package com.distinct.tamyg.twitterclient.images;

import com.distinct.tamyg.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by tamyg on 20/06/16.
 */
public interface ImagesView {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
