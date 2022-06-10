package br.com.agenda.app;

import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.Agenda;
import br.com.agenda.model.Contact;

public class Main {
    private static String DIVIDER = "------------------------------------------------------";
    private static String HEADER = " Id  |           Name | Age | Sign date  | Log Date";
    private static final Agenda AGENDA = new Agenda();

    public static void main(String[] args) {

        if (args.length == 0)
            manual();
        else
            auto(args);
    }

    /* Auto-update DataBase based on the arguments passed to the application at CLI. */
    static void auto(String[] args) {
        boolean doForce = false;

        switch (args[0]) {
            case "-c":
                if (args.length != 3)
                    System.out.printf("Too %s arguments.\n", args.length > 3 ? "many" : "few");
                else
                    saveContact(args[1], Integer.parseInt(args[2]));
                break;
            case "-r":
                read();
                break;
            case "-u":
                if (args.length != 4)
                    System.out.printf("Too %s arguments.\n", args.length > 4 ? "many" : "few");
                else {
                    Contact contact = AGENDA.getContact(Integer.parseInt(args[1]));
                    System.out.println("Updating contact:");
                    printContact(contact);
                    System.out.println(DIVIDER);
                    contact.setName(args[2]);
                    contact.setAge(Integer.parseInt(args[3]));
                    AGENDA.update(contact);
                    printContact(contact);
                }
                break;
            case "-df":
                doForce = true;
            case "-d":
                if (args.length != 2)
                    System.out.printf("Too %s arguments.\n", args.length > 2 ? "many" : "few");
                else {
                    Contact contact = AGENDA.getContact(Integer.parseInt(args[1]));
                    System.out.println("Deleting contact:");
                    printContact(contact);
                    System.out.println(DIVIDER);

                    if (!doForce && !askDeletion(new Scanner(System.in))) {
                        System.out.println("Operation aborted!");
                        break;
                    }

                    AGENDA.deleteByID(contact.getId());
                    System.out.printf("%s deleted successfully!\n", contact.toString());
                }
                break;
            default: System.out.println("Option do not exists.");
        }
    }

    /* Manually operates over the application's DataBase. */
    static void manual() {
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        try {
            do {
                printMenu();
                choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 1: create(scan); break;
                    case 2: read(); break;
                    case 3: update(scan); break;
                    case 4: delete(scan); break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }

    }

    /* Helper method to display the menu. */
    private static void printMenu() {
        final String LINE = "--------------------------";
        System.out.println("Agenda Java MySQL DataBase");
        System.out.println(LINE);
        System.out.println("Welcome!");
        System.out.println(LINE);
        System.out.println("1 - Create");
        System.out.println("2 - Read");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
        System.out.println("0 - Exit");
        System.out.printf(">>> ");
    }

    /* Helper method to manually create a new DataBase entry at the CLI. */
    private static void create(Scanner scan) {
        System.out.printf("Name: ");
        String name = scan.nextLine();

        System.out.printf("Age: ");
        saveContact(name, scan.nextInt());
        scan.nextLine();

        System.out.println();
    }

    /* Prints the DataBase entries. */
    static void read() {
        System.out.printf("%s\n%s\n%s\n", DIVIDER, HEADER, DIVIDER);

        for (Contact contact : AGENDA.getContacts()) {
            printContact(contact);
            System.out.println(DIVIDER);
        }
    }

    /* Helper method to manually update a DataBase's entry at the CLI. */
    static void update(Scanner scan) {
        Contact contact;

        System.out.printf("Insert contact id: ");
        contact = AGENDA.getContact(scan.nextInt());
        int choice;

        do {
            System.out.printf("%s\n%s\n%s\n", DIVIDER, HEADER, DIVIDER);
            printContact(contact);
            System.out.println(DIVIDER);
            System.out.println("1 - Update name");
            System.out.println("2 - Update age");
            System.out.println("0 - Stop update");
            System.out.printf(">>> ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1: {
                    System.out.printf("New name: ");
                    contact.setName(scan.nextLine());
                    // Sets the log date when a change has been made.
                    contact.setLogDate(new Date());
                } break;
                case 2: {
                    System.out.printf("New age: ");
                    contact.setAge(scan.nextInt());
                    scan.nextLine();
                    contact.setLogDate(new Date());
                } break;
            }
        } while (choice != 0);

        // Updates the changes in the DataBase
        AGENDA.update(contact);
    }

    /* Helper method to manually delete a DataBase's entry at the CLI. */
    static void delete(Scanner scan) {
        Contact contact;
        int id;

        System.out.println("Insert contact id: ");
        id = scan.nextInt();
        scan.nextLine();
        contact = AGENDA.getContact(id);

        System.out.println(DIVIDER);
        printContact(contact);
        System.out.println(DIVIDER);

        if (askDeletion(scan)) {
            System.out.println("Operation aborted!");
            return;
        }

        AGENDA.deleteByID(id);
        System.out.printf("%s deleted successfully!\n", contact.toString());
    }

    static boolean askDeletion(Scanner scan) {
        System.out.printf("Are you sure to delete the entry? (y/n) ");
        return scan.nextLine().toLowerCase().startsWith("y");
    }

    /* Helper method that prints a single entry from the DataBase. */
    static void printContact(Contact contact) {
        System.out.printf(" %-3d | %14s | %3d | %9s | %s\n",
                contact.getId(), contact.getName(), contact.getAge(),
                contact.getSignDate(), contact.getLogDate());
    }

    /* Helper method to save a new DataBase entry. */
    static void saveContact(String name, int age) {
        Contact contact = new Contact();
        Date date = new Date();
        contact.setName(name);
        contact.setAge(age);
        contact.setSignDate(date);
        contact.setLogDate(date);
        AGENDA.save(contact);
        System.out.printf("%s saved successfully!\n", contact.toString());
    }

}
