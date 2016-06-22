package com.distinct.tamyg.twitterclient.hashtags.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.distinct.tamyg.twitterclient.R;
import com.distinct.tamyg.twitterclient.entities.Hashtag;
import com.distinct.tamyg.twitterclient.hashtags.ui.CustomGridLayoutManager;
import com.distinct.tamyg.twitterclient.hashtags.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tamyg on 21/06/16.
 */
public class HashtagAdapter extends RecyclerView.Adapter<HashtagAdapter.ViewHolder>  {

    private List<Hashtag> items;
    private OnItemClickListener clickListener;

    public HashtagAdapter(List<Hashtag> items, OnItemClickListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_hashtags, parent, false);
        return new ViewHolder(parent.getContext(), view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag tweet = items.get(position);
        holder.setClickListener(tweet, clickListener);
        holder.txtTweet.setText(tweet.getTweetText());
        holder.setItems(tweet.getHashtags());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Hashtag> items) {
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.recyclerViewHashtags)
        RecyclerView recyclerView;

        private View view;
        private ArrayList<String> items;
        private HashtagsListAdapter adapter;

        public ViewHolder(Context context, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;

            items = new ArrayList<>();
            adapter = new HashtagsListAdapter(items);
            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setClickListener(final Hashtag tweet,
                                     final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(tweet);
                }
            });

        }

        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }
    }
}
