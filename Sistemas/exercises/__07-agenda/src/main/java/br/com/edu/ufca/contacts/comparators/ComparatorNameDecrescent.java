package br.com.edu.ufca.contacts.comparators;

import java.util.Comparator;

import br.com.edu.ufca.Contact;

public class ComparatorNameDecrescent implements Comparator<Contact> {

    @Override
    public int compare(Contact contato1, Contact contato2) {
        // TODO Auto-generated method stub
        if (contato1.getName().compareTo(contato2.getName()) > 0) {
            // o contato 1 vem antes do contato 2
            return -1;
        }
        // o contato 2 vem antes do contato 1
        return 1;
    }

}
