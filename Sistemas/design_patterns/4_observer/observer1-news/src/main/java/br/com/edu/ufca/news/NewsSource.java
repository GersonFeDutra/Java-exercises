package br.com.edu.ufca.news;

import java.util.ArrayList;

public abstract class NewsSource {
    // In a real application, would be better to use a hashmap
    protected ArrayList<News> subscribers;

    public NewsSource() {
        this.subscribers = new ArrayList<News>();
    }

    public void subscribe(News news) {

        // Enable to protect from duplicated callbacks.
        // if (this.subscribers.contains(news))
            // return;

        this.subscribers.add(news);
    }

    public boolean unsubscribe(News news) {
        return this.subscribers.remove(news);
    }

    abstract protected void send();

}
