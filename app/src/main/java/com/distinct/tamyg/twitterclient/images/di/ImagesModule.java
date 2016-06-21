package com.distinct.tamyg.twitterclient.images.di;


import com.distinct.tamyg.twitterclient.api.CustomTwitterApiClient;
import com.distinct.tamyg.twitterclient.entities.Image;
import com.distinct.tamyg.twitterclient.images.ImagesInteractor;
import com.distinct.tamyg.twitterclient.images.ImagesInteractorImpl;
import com.distinct.tamyg.twitterclient.images.ImagesPresenter;
import com.distinct.tamyg.twitterclient.images.ImagesPresenterImpl;
import com.distinct.tamyg.twitterclient.images.ImagesRepository;
import com.distinct.tamyg.twitterclient.images.ImagesRepositoryImpl;
import com.distinct.tamyg.twitterclient.images.ui.ImagesView;
import com.distinct.tamyg.twitterclient.images.ui.adapters.ImagesAdapter;
import com.distinct.tamyg.twitterclient.images.ui.adapters.OnItemClickListener;
import com.distinct.tamyg.twitterclient.lib.base.EventBus;
import com.distinct.tamyg.twitterclient.lib.base.ImageHolder;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamyg on 20/06/16.
 */
@Module
public class ImagesModule  {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Image> provideItems() {
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    ImagesAdapter provideAdapter(List<Image> items, OnItemClickListener clickListener, ImageHolder imageLoader) {
        return new ImagesAdapter(items, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    ImagesView provideImagesView() {
        return this.view;
    }

    @Provides
    @Singleton
    ImagesPresenter provideImagesPresenter(ImagesView view, ImagesInteractor interactor, EventBus eventBus) {
        return new ImagesPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    ImagesInteractor provideImagesInteractor(ImagesRepository repository) {
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository provideImagesRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
