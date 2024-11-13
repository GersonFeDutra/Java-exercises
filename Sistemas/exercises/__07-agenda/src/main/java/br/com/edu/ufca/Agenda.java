package br.com.edu.ufca;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.edu.ufca.contacts.Individual;
import br.com.edu.ufca.contacts.LegalEntity;

// TODO -> Implementar acesso ao banco de dados com SQLite
public class Agenda {

    private Hashtable<String, Contact> contacts;
    private ArrayList<Contact> contactsList;

    public static int lastId = 0;

    public Agenda() {
        contacts = new Hashtable<String, Contact>();
        contactsList = new ArrayList<Contact>();
    }

    public Agenda(List<? extends Contact> contacts) {
        this();

        for (Contact contact : contacts)
            addContact(contact);
    }

    public boolean addContact(Contact newContact) {

        String id;
        if (newContact instanceof Individual)
            id = ((Individual) newContact).cpf;
        else if (newContact instanceof LegalEntity)
            id = ((LegalEntity) newContact).cnpj;
        else {
            do {
                if (newContact.getId() == -1)
                    newContact.setId(++lastId);

                id = newContact.toString();
            } while (contacts.containsKey(id));
        }

        if (contacts.containsKey(id))
            return false;

        contacts.put(id, newContact);
        contactsList.add(newContact);

        return true;
    }

    public boolean removeContact(Contact contact) {
        boolean wasRemoved = contactsList.remove(contact);
        contacts.remove(contact.getName());

        return wasRemoved;
    }

    public void showContacts() {

        for (Contact c : contactsList) {
            c.showInfo();
            System.out.println();
        }
    }

    public ArrayList<Contact> getContatos() {
        return contactsList;
    }

    public Contact getContact(String id) {
        return contacts.getOrDefault(id, null);
    }

    public int getContactsN() {
        return this.contactsList.size();
    }
}
