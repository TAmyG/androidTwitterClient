package com.distinct.tamyg.twitterclient.hashtags.di;

import com.distinct.tamyg.twitterclient.TwitterClientApp;
import com.distinct.tamyg.twitterclient.hashtags.ui.HashtagFragment;
import com.distinct.tamyg.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tamyg on 21/06/16.
 */
@Singleton @Component(modules = {HashtagModule.class, LibsModule.class})
public interface HashtagsComponent {
    void inject(HashtagFragment fragment);
}
