package br.com.edu.ufca.news.concrete;

import br.com.edu.ufca.news.News;

public class Publisher implements News {
    @Override
    public void notify(String text, int day, int month, String topic) {
        System.out.printf("Publicando (%s) %02d/%02d:\n", topic, day, month);
        System.out.println(text);
    }
}
