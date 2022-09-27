package br.com.edu.ufca.news.concrete;

import java.util.ArrayList;

import br.com.edu.ufca.news.News;
import br.com.edu.ufca.news.NewsSource;

public abstract class Aggregator extends NewsSource implements News {
    protected ArrayList<String> feed;

    public Aggregator() {
        this.feed = new ArrayList<String>();
    }

    public ArrayList<String> getFeed() {
        return this.feed;
    }
}
