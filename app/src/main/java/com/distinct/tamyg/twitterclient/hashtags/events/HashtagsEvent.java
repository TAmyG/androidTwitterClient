package com.distinct.tamyg.twitterclient.hashtags.events;

import com.distinct.tamyg.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by tamyg on 21/06/16.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
