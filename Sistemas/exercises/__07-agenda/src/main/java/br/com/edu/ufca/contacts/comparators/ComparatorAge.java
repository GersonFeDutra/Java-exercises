package br.com.edu.ufca.contacts.comparators;

import java.util.Comparator;

import br.com.edu.ufca.contacts.Individual;

public class ComparatorAge implements Comparator<Individual> {

    @Override
    public int compare(Individual individualA, Individual individualB) {

        if (individualA.birthDate.compareTo(individualB.birthDate) > 0)
            // o contato A vem antes do contato B
            return 1;

        // o contato B vem antes do contato A
        return -1;
    }

}
