package br.com.edu.ufca.news;

import java.util.ArrayList;
import java.util.Calendar;

public class Source extends NewsSource {
    private ArrayList<Event> newsLetter;

    public Source() {
        super();
        this.newsLetter = new ArrayList<Event>();
    }

    public ArrayList<Event> getNewsLetter() {
        return newsLetter;
    }

    public void appendEvent(Event event) {
        this.newsLetter.add(event);
        send();
    }

    /* Simplesmente, notificará o último evento ocorrido. */
    @Override
    protected void send() {
        Event lasEvent = newsLetter.get(newsLetter.size() - 1);
        Calendar calendar = Calendar.getInstance();

        for (News subscriber : subscribers)
            subscriber.notify(
                    lasEvent.getDescription(),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.MONTH),
                    lasEvent.getType());
    }
}
