package com.distinct.tamyg.twitterclient.images;

import com.distinct.tamyg.twitterclient.images.events.ImagesEvent;

/**
 * Created by tamyg on 20/06/16.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
