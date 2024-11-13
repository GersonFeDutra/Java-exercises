package br.com.edu.ufca.contacts.sorters;

import br.com.edu.ufca.Contact;
import br.com.edu.ufca.contacts.comparators.ComparatorNameCrescent;

public class NameSorter extends ContactSorter {

    @Override
    public int compare(Contact contactA, Contact contactB) {
        ComparatorNameCrescent cnc = new ComparatorNameCrescent();

        return cnc.compare(contactA, contactB);
    }

}
