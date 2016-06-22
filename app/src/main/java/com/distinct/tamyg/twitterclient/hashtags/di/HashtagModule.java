package com.distinct.tamyg.twitterclient.hashtags.di;


import com.distinct.tamyg.twitterclient.api.CustomTwitterApiClient;
import com.distinct.tamyg.twitterclient.entities.Hashtag;
import com.distinct.tamyg.twitterclient.hashtags.HashtagInteractor;
import com.distinct.tamyg.twitterclient.hashtags.HashtagInteractorImpl;
import com.distinct.tamyg.twitterclient.hashtags.HashtagPresenter;
import com.distinct.tamyg.twitterclient.hashtags.HashtagPresenterImpl;
import com.distinct.tamyg.twitterclient.hashtags.HashtagRepository;
import com.distinct.tamyg.twitterclient.hashtags.HashtagsRepositoryImpl;
import com.distinct.tamyg.twitterclient.hashtags.ui.HashtagView;
import com.distinct.tamyg.twitterclient.hashtags.ui.OnItemClickListener;
import com.distinct.tamyg.twitterclient.hashtags.ui.adapters.HashtagAdapter;
import com.distinct.tamyg.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamyg on 21/06/16.
 */
@Module
public class HashtagModule {
    private HashtagView view;
    private OnItemClickListener clickListener;

    public HashtagModule(HashtagView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> provideItems() {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideOnClickListener() {
        return this.clickListener;
    }

    @Provides
    @Singleton
    HashtagAdapter provideAdapter(List<Hashtag> items, OnItemClickListener clickListener) {
        return new HashtagAdapter(items, clickListener);
    }

    @Provides
    @Singleton
    HashtagView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagPresenter provideHashtagsPresenter(HashtagView view, HashtagInteractor interactor, EventBus eventBus) {
        return new HashtagPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagInteractor provideHashtagsInteractor(HashtagRepository repository) {
        return new HashtagInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagRepository provideHashtagsRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(client, eventBus);
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
