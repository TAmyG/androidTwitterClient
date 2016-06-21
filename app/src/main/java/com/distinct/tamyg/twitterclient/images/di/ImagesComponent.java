package com.distinct.tamyg.twitterclient.images.di;

import com.distinct.tamyg.twitterclient.images.ImagesPresenter;
import com.distinct.tamyg.twitterclient.images.ui.ImagesFragment;
import com.distinct.tamyg.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tamyg on 20/06/16.
 */
@Singleton @Component(modules = {LibsModule.class ,ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
