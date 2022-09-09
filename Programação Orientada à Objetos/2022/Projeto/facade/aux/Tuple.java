package facade.aux;

import people.Person;

/*
 * Classe auxiliar para armazenar um dado número de pedidos associado a uma
 * pessoa.
 */
public class Tuple {
    public int nDemands;
    public Person person;

    public Tuple(int nDemands, Person person) {
        this.nDemands = nDemands;
        this.person = person;
    }

    public Tuple(Person person) {
        this.nDemands = 0;
        this.person = person;
    }
}
