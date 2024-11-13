package br.com.edu.ufca.contacts.sorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.edu.ufca.Agenda;
import br.com.edu.ufca.Contact;

public abstract class ContactSorter implements Comparator<Contact> {

    @Override
    public abstract int compare(Contact contactA, Contact contactB);

    public ArrayList<Contact> sort(Agenda agenda) {
        ArrayList<Contact> contactsList = new ArrayList<Contact>(agenda.getContatos());
        Collections.sort(contactsList, this);

        return contactsList;
    }

}
