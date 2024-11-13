package br.com.edu.ufca.contacts.comparators;

import java.util.Comparator;

import br.com.edu.ufca.Contact;

public class ComparatorNameCrescent implements Comparator<Contact> {

	@Override
	public int compare(Contact contactA, Contact contactB) {

		if (contactA.getName().compareTo(contactB.getName()) > 0) {
			// o contato A vem antes do contato B
			return 1;
		}
		// o contato B vem antes do contato A
		return -1;
	}
}
