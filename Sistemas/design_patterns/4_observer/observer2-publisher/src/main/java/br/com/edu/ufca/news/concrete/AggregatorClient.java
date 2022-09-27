package br.com.edu.ufca.news.concrete;

import br.com.edu.ufca.news.News;

public class AggregatorClient implements News {
    private boolean feedReady = false;
    private String content;

    @Override
    public void notify(String text, int day, int month, String topic) {
        content = String.format("Publicando feed de notícias (%s) %02d/%02d:\n%s",
                topic, day, month, text);

        feedReady = true;
    }

    public boolean isFeedReady() {
        return this.feedReady;
    }

    public String consumeContent() {
        String content = this.content;
        this.content = "";

        return content;
    }
}
