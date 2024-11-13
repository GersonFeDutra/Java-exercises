package br.com.edu.ufca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import br.com.edu.ufca.Contact.AddressType;
import br.com.edu.ufca.contacts.Individual;
import br.com.edu.ufca.contacts.LegalEntity;
import br.com.edu.ufca.contacts.comparators.ComparatorAge;
import br.com.edu.ufca.contacts.comparators.ComparatorNameDecrescent;
import br.com.edu.ufca.contacts.sorters.AgeSorter;
import br.com.edu.ufca.contacts.sorters.NameSorter;

public class TestAgenda {

    public static void main(String[] args) {
        Contact[] contacts = {
                new Contact(
                        "Fábio", "fabio.silva@gmail.com", "(83) 98765.0987",
                        AddressType.COMERCIAL),
                new Contact(
                        "Patricia", "patricia.santos@gmail.com", "(88) 99087.0987",
                        AddressType.RESIDENTIAL),
                new Individual(
                        "Ana", "ana_098@gmail.com", "(83) 98765.0987", "023 001 468 - 2",
                        LocalDateTime.of(2010, 6, 21, 22, 13, 00)),
                new Individual(
                        "Rafael", "rafael18@gmail.com", "(88) 99087.0987", "023 001 345 - 1",
                        LocalDateTime.of(1997, 11, 13, 14, 10, 00)),
                new LegalEntity("Amazon Services", "services@amazon.com.br", "(52) 95432.2134", "cd000431-28"),
        };
        Agenda myAgenda = new Agenda();

        for (Contact contact : contacts)
            if (myAgenda.addContact(contact))
                System.out.println("Contato adicionado!");
            else
                System.out.println("Não foi possível adicionar contato: " + contact.getName());

        System.out.println();
        myAgenda.showContacts();
        System.out.printf("\t\t\tTotal de contatos: %d.\n", myAgenda.getContactsN());

        // if (myAgenda.removeContact(contacts[1]))
        // System.out.println("Contato removido!");

        // System.out.println();
        // myAgenda.showContacts();

        System.out.println();
        System.out.println("------- Lista ordenada por nome crescente --------");
        // ArrayList<Contact> contactsList = new
        // ArrayList<Contact>(myAgenda.getContatos());
        // Collections.sort(contactsList, new ComparatorNameCrescent());
        // myAgenda = new Agenda(contactsList);
        myAgenda = new Agenda((new NameSorter()).sort(myAgenda));
        myAgenda.showContacts();

        System.out.println();
        System.out.println("------- Lista ordenada por nome decrescente --------");
        ArrayList<Contact> contactsList2 = new ArrayList<Contact>(myAgenda.getContatos());
        Collections.sort(contactsList2, new ComparatorNameDecrescent());
        myAgenda = new Agenda(contactsList2);
        myAgenda.showContacts();

        System.out.println();
        System.out.println("----------------- Buscando contatos ----------------");
        System.out.println("id: 0");
        Contact contact = myAgenda.getContact("contact:0");

        if (contact != null)
            System.out.printf("\tContato: %s <%s>\n", contact.getName(), contact.getEmail());
        else
            System.out.println("Contato não encontrado!");

        System.out.println("cpf: 023 001 345 - 1");
        contact = myAgenda.getContact("023 001 345 - 1");

        if (contact != null)
            System.out.printf("\tContato: %s <%s>\n", contact.getName(), contact.getEmail());
        else
            System.out.println("Contato não encontrado!");

        System.out.println("cnpj: cd000431-28");
        contact = myAgenda.getContact("cd000431-28");

        if (contact != null)
            System.out.printf("\tContato: %s <%s>\n", contact.getName(), contact.getEmail());
        else
            System.out.println("Contato não encontrado!");

        System.out.println();
        System.out.println("------------ Lista ordenada por idade ------------");
        ArrayList<Individual> individualsList = new ArrayList<Individual>();

        for (Contact _contact : contactsList2)
            if (_contact instanceof Individual)
                individualsList.add((Individual) _contact);

        // Collections.sort(individualsList, new ComparatorAge());
        // myAgenda = new Agenda((new AgeSorter()).sort(myAgenda));
        myAgenda = new Agenda(individualsList);
        myAgenda = new Agenda((new AgeSorter()).sort(myAgenda));
        myAgenda.showContacts();
    }

}
