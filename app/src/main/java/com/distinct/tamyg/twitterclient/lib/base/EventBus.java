package com.distinct.tamyg.twitterclient.lib.base;

/**
 * Created by tamyg on 17/06/16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
