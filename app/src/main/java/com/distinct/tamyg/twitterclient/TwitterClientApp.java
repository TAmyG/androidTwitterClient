package com.distinct.tamyg.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.distinct.tamyg.twitterclient.hashtags.di.DaggerHashtagsComponent;
import com.distinct.tamyg.twitterclient.hashtags.di.HashtagModule;
import com.distinct.tamyg.twitterclient.hashtags.di.HashtagsComponent;
import com.distinct.tamyg.twitterclient.hashtags.ui.HashtagView;
import com.distinct.tamyg.twitterclient.images.di.DaggerImagesComponent;
import com.distinct.tamyg.twitterclient.images.di.ImagesComponent;
import com.distinct.tamyg.twitterclient.images.di.ImagesModule;
import com.distinct.tamyg.twitterclient.images.ui.ImagesView;
import com.distinct.tamyg.twitterclient.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.*;

import io.fabric.sdk.android.Fabric;

/**
 * Created by tamyg on 17/06/16.
 */
public class TwitterClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, com.distinct.tamyg.twitterclient.images.ui.adapters.OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }

    public HashtagsComponent getHashtagsComponent(HashtagView view, com.distinct.tamyg.twitterclient.hashtags.ui.OnItemClickListener clickListener){
        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagModule(new HashtagModule(view, clickListener))
                .build();
    }
}
