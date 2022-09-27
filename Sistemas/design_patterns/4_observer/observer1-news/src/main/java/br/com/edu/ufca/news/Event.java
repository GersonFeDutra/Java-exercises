package br.com.edu.ufca.news;

public class Event {
    // Event's data are persistent (can't be modified once created).
    private final String description;
    private final String type;

    public Event(String description, String type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }
}
