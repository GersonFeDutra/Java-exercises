package library;

import java.util.ArrayList;
import java.util.Hashtable;

import library.items.Book;
import library.items.Magazine;
import library.items.Readable;
import library.items.games.BoardGame;
import library.items.games.Game;
import library.items.games.VideoGame;

public class Library {
    private String[] sessions;
    private Hashtable<String, Article> articles;

    public Library() {
        int id = 0;
        Article current;
        ArrayList<Book> books;
        ArrayList<Game> games;
        ArrayList<Magazine> magazines;

        this.articles = new Hashtable<String, Article>();

        // Seção de suspense
        final String SUSPENSE = "Suspense";
        current = new Article();
        double suspense_price = 80.0;

        books = new ArrayList<Book>();
        String[] suspense_books = {
            "The Shining", "The Cube", "Coherence"};

        for (String title : suspense_books) {
            books.add(new Book(id++, title, suspense_price, Readable.PRINTED));
            books.add(new Book(id++, title, suspense_price, Readable.DIGITAL));
        }
        current.addBooks(books);

        suspense_price *= 2.0;
        games = new ArrayList<Game>();

        String[] suspense_games = {
            "Silent Hill", "Fatal Frame", "Resident Evil"
        };
        for (String title : suspense_games) {
            games.add(new VideoGame(id++, title, suspense_price));
        }

        current.addGames(games);
        this.articles.put(SUSPENSE, current);

        // Seção de cultura Pop
        final String POP = "Pop";
        current = new Article();
        double pop_price = 50.0;

        String[] pop_magazines = {
            "Nintendo Power", "Scott Pilgrim vs The World", "Game Spot"};
        magazines = new ArrayList<Magazine>();

        for (String title : pop_magazines) {
            magazines.add(new Magazine(id++, title, pop_price, Readable.PRINTED));
            magazines.add(new Magazine(id++, title, pop_price, Readable.DIGITAL));
        }
        current.addMagazines(magazines);

        String[] pop_games = {
            "Katamari Damaci", "Super Mario World 2", "Terraria"};
        games = new ArrayList<Game>();

        pop_price *= 2.4;
        for (String title : pop_games)
            games.add(new VideoGame(id++, title, pop_price));

        String[] board_games = {
            "Dungeons & Dragons", "Munchkin", "WAR",
        };
        pop_price *= 0.9;
        for (String title : board_games)
            games.add(new BoardGame(id++, title, pop_price));
        current.addGames(games);

        this.articles.put(POP, current);

        this.sessions = new String[2];
        this.sessions[0] = POP;
        this.sessions[1] = SUSPENSE;
    }

    public String[] getSessions() {
        return sessions;
    }

    public Article getArticle(String fromSession) {
        Article article = this.articles.get(fromSession);

        if (article != null)
            return article;

        return new Article(); // Empty Article
    }

}
