package br.com.edu.ufca;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.edu.ufca.news.Event;
import br.com.edu.ufca.news.NewsClient;
import br.com.edu.ufca.news.Source;

/*
 * App
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();
        ArrayList<Event> events = newsParser();
        Random rand = new Random();

        source.subscribe(new NewsClient());

        while (!events.isEmpty()) {
            System.out.printf("Divulgando");

            for (int i = 0; i < 3; ++i) {
                System.out.printf(".");
                Thread.sleep(333);
            }
            System.out.printf("\n");
            source.appendEvent(events.remove(rand.nextInt(events.size())));
            Thread.sleep(666);
            System.out.println();
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
