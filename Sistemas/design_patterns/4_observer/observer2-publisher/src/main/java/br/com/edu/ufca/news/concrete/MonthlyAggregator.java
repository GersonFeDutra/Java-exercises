package br.com.edu.ufca.news.concrete;

import br.com.edu.ufca.news.News;

public class MonthlyAggregator extends Aggregator {
    private int lastNewsMonth = 0;

    public MonthlyAggregator() {
        super();
    }

    @Override
    public void notify(String text, int day, int month, String topic) {
        this.feed.add(text);
        this.lastNewsMonth = month;

        if (lastNewsMonth == month)
            return;

        if (lastNewsMonth == 0) {
            lastNewsMonth = month;
            return;
        }

        send();
        this.feed.clear();
        lastNewsMonth = month;
    }

    @Override
    protected void send() {
        StringBuilder journal = new StringBuilder();
        for (String content : feed)
            journal.append(String.format("%s\n", content));

        for (News subscriber : subscribers)
            subscriber.notify(journal.toString(), 0, lastNewsMonth, "mensal");

    }

    public int getLastNewsMonth() {
        return lastNewsMonth;
    }
}
