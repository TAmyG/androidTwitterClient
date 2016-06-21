package com.distinct.tamyg.twitterclient.images;

/**
 * Created by tamyg on 20/06/16.
 */
public class ImagesInteractorImpl implements ImagesInteractor {
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
