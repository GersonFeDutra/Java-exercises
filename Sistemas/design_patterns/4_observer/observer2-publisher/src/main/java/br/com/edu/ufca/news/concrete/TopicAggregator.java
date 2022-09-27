package br.com.edu.ufca.news.concrete;

import br.com.edu.ufca.news.News;

public class TopicAggregator extends Aggregator {
    static final private int FEED_LENGTH = 10;
    private int lastNewsDay = 0;
    private int lastNewsMonth = 0;
    private String topic;

    public TopicAggregator(String topic) {
        super();
        this.topic = topic;
    }

    @Override
    public void notify(String text, int day, int month, String topic) {

        if (this.topic.equals(topic)) {
            this.feed.add(text);
            this.lastNewsDay = day;
            this.lastNewsMonth = month;

            if (feed.size() != FEED_LENGTH)
                return;

            send();
            clear();
        }
    }

    @Override
    protected void send() {
        StringBuilder journal = new StringBuilder();
        for (String content : feed)
            journal.append(String.format("%s\n", content));

        for (News subscriber : subscribers)
            subscriber.notify(journal.toString(), lastNewsDay, lastNewsMonth, topic);

    }

    private void clear() {
        this.feed.clear();
        this.lastNewsDay = 0;
        this.lastNewsMonth = 0;
    }

    public int getLastNewsDay() {
        return lastNewsDay;
    }

    public int getLastNewsMonth() {
        return lastNewsMonth;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        if (topic.equals(topic))
            return;

        this.topic = topic;
        clear();
    }
}
