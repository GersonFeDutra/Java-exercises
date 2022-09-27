package br.com.edu.ufca.news;

public class NewsClient implements News {
    @Override
    public void notify(String text, int day, int month, String topic) {
        System.out.printf("Publicando (%s) %d/%d:\n", topic, day, month);
        System.out.println(text);
    }
}
