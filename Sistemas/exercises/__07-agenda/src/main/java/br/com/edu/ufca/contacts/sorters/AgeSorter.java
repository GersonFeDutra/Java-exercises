package br.com.edu.ufca.contacts.sorters;

import br.com.edu.ufca.Contact;
import br.com.edu.ufca.contacts.Individual;
import br.com.edu.ufca.contacts.comparators.ComparatorAge;

public class AgeSorter extends ContactSorter {

    @Override
    public int compare(Contact contactA, Contact contactB) {
        ComparatorAge cnc = new ComparatorAge();

        return cnc.compare((Individual) contactA, (Individual) contactB);
    }

}
