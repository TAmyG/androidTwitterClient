package com.distinct.tamyg.twitterclient.hashtags;

import com.distinct.tamyg.twitterclient.entities.Hashtag;
import com.distinct.tamyg.twitterclient.hashtags.events.HashtagsEvent;
import com.distinct.tamyg.twitterclient.hashtags.ui.HashtagView;
import com.distinct.tamyg.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by tamyg on 21/06/16.
 */
public class HashtagPresenterImpl implements HashtagPresenter {

    private EventBus eventBus;
    private HashtagView hashtagsView;
    private HashtagInteractor hashtagsInteractor;

    public HashtagPresenterImpl(HashtagView hashtagsView, HashtagInteractor hashtagsInteractor, EventBus eventBus) {
        this.eventBus = eventBus;
        this.hashtagsView = hashtagsView;
        this.hashtagsInteractor = hashtagsInteractor;
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.hashtagsView = null;
    }

    @Override
    public void getHashtagTweets(){
        if (this.hashtagsView != null){
            hashtagsView.hideList();
            hashtagsView.showProgress();
        }
        this.hashtagsInteractor.getHashtagItemsList();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (this.hashtagsView != null) {
            hashtagsView.showList();
            hashtagsView.hideProgress();
            if (errorMsg != null) {
                this.hashtagsView.onHashtagsError(errorMsg);
            } else {
                List<Hashtag> items = event.getHashtags();
                if (items != null && !items.isEmpty()) {
                    this.hashtagsView.setHashtags(items);
                }
            }
        }
    }
}
