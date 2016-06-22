package com.distinct.tamyg.twitterclient.hashtags;

/**
 * Created by tamyg on 21/06/16.
 */
public class HashtagInteractorImpl implements HashtagInteractor {
    private HashtagRepository hashtagsRepository;

    public HashtagInteractorImpl(HashtagRepository hashtagsRepository) {
        this.hashtagsRepository = hashtagsRepository;
    }

    @Override
    public void getHashtagItemsList() {
        hashtagsRepository.getHashtags();
    }
}
