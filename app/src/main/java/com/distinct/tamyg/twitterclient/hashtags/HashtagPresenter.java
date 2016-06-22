package com.distinct.tamyg.twitterclient.hashtags;

import com.distinct.tamyg.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by tamyg on 21/06/16.
 */
public interface HashtagPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
