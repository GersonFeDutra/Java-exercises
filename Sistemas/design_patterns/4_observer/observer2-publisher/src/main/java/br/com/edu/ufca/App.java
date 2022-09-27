package br.com.edu.ufca;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.edu.ufca.news.Event;
import br.com.edu.ufca.news.Source;
import br.com.edu.ufca.news.concrete.AggregatorClient;
import br.com.edu.ufca.news.concrete.MonthlyAggregator;
import br.com.edu.ufca.news.concrete.Publisher;
import br.com.edu.ufca.news.concrete.TopicAggregator;

/*
 * App
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        try (Scanner keyboard = new Scanner(System.in)) {
            run(keyboard);
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void run(Scanner keyboard) throws InputMismatchException, InterruptedException {
        final String TOPIC = "inovação tecnológica";

        Source source = new Source();
        ArrayList<Event> events = newsParser();
        Random rand = new Random();

        TopicAggregator topicAgg = new TopicAggregator(TOPIC);
        AggregatorClient topicFeed = new AggregatorClient();
        topicAgg.subscribe(topicFeed);

        MonthlyAggregator monthlyAgg = new MonthlyAggregator();
        AggregatorClient monthlyFeed = new AggregatorClient();
        monthlyAgg.subscribe(monthlyFeed);

        source.subscribe(monthlyAgg);
        source.subscribe(topicAgg);
        source.subscribe(new Publisher());

        int c = 0;
        while (!events.isEmpty()) {
            System.out.printf("Nova notícia publicada");

            for (int i = 0; i < 3; ++i) {
                System.out.printf(".");
                Thread.sleep(333);
            }
            System.out.printf("\n");
            source.appendEvent(events.remove(rand.nextInt(events.size())));
            Thread.sleep(666);
            System.out.println();

            if (++c != 3)
                continue;
            c = 0;

            System.out.println();
            System.out.println("Consultar Feed de notícias:");
            boolean topicFeedReady = topicFeed.isFeedReady();
            boolean monthlyFeedReady = monthlyFeed.isFeedReady();

            System.out.printf("%s - tópico %s\n", topicFeedReady ? "[ ✔ ] 1" : "[ ❌ ]", TOPIC);
            System.out.printf("%s - mensal\n", (monthlyFeedReady ? "[ ✔ ] 2" : "[ ❌ ]"));
            System.out.println("0 - continuar");
            System.out.printf(">>> ");
            String noNewsWarn = "Notícias indisponíveis! Continuando...";
            String warn = "Opção inválida! Continuando...";

            int opt = keyboard.nextInt();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    if (topicFeedReady) {
                        System.out.println(topicFeed.consumeContent());
                        System.out.println("Pressione Enter para continuar...");
                        keyboard.nextLine();
                        break;
                    } else {
                        warn = noNewsWarn;
                    }
                case 2:
                    if (monthlyFeedReady) {
                        System.out.println(monthlyFeed.consumeContent());
                        System.out.println("Pressione Enter para continuar...");
                        keyboard.nextLine();
                        break;
                    } else {
                        warn = noNewsWarn;
                    }
                default:
                    System.out.println(warn);
            }
        }
    }

    private static ArrayList<Event> newsParser() {
        final String EVENTS_PATH = "src/main/resources/events.json";

        ArrayList<Event> parsedEvents = new ArrayList<Event>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(EVENTS_PATH));
            // convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            // Reading the String
            JSONObject descriptions = (JSONObject) jsonObject.get("descriptions");
            JSONArray types = (JSONArray) jsonObject.get("types");

            for (Object type : types)
                for (Object description : (JSONArray) descriptions.get(type))
                    parsedEvents.add(new Event(description.toString(), type.toString()));

        } catch (FileNotFoundException | ParseException fe) {
            System.err.println("Error reading JSON file:");
            fe.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException:");
            e.printStackTrace();
        }

        return parsedEvents;
    }
}
