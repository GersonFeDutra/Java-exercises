package library;

import java.util.ArrayList;
import java.util.Collection;

import library.items.*;
import library.items.games.Game;

public class Article {
    private ArrayList<Magazine> magazines;
    private ArrayList<Book> books;
    private ArrayList<Game> games;

    public Article() {
        this.magazines = new ArrayList<Magazine>();
        this.books = new ArrayList<Book>();
        this.games = new ArrayList<Game>();
    }

    public ArrayList<Item> getItemsList() {
        ArrayList<Item> list = new ArrayList<Item>();

        list.addAll(magazines);
        list.addAll(books);
        list.addAll(games);

        return list;
    }

    public Item getItem(int id) {

        for (Magazine magazine : magazines)
            if (magazine.getId() == id)
                return magazine;

        for (Book book : books)
            if (book.getId() == id)
                return book;

        for (Game game : games)
            if (game.getId() == id)
                return game;

        return new NullItem();
    }

    public ArrayList<Magazine> getMagazines() {
        return this.magazines;
    }

    public void addMagazines(Collection<Magazine> collection) {
        this.magazines.addAll(collection);
    }

    public void addGames(Collection<Game> collection) {
        this.games.addAll(collection);
    }

    public void addBooks(Collection<Book> collection) {
        this.books.addAll(collection);
    }

}
