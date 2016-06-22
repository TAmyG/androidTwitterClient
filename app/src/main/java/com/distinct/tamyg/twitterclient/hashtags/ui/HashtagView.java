package com.distinct.tamyg.twitterclient.hashtags.ui;

import com.distinct.tamyg.twitterclient.entities.Hashtag;
import com.distinct.tamyg.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by tamyg on 21/06/16.
 */
public interface HashtagView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
