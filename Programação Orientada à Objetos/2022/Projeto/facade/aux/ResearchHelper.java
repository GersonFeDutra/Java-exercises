package facade.aux;

import people.Person;
import restaurants.Restaurant;

/* Classe Auxiliar que processará os dados na pesquisa de pedidos. */
public class ResearchHelper {
    boolean started = false;
    Restaurant restaurant1;
    Restaurant restaurant2;
    // Pessoas com mais pedidos.
    public Tuple _total;
    // Mais pedidos no restaurante.
    public Tuple _rest1;
    public Tuple _rest2;

    public ResearchHelper(Restaurant a, Restaurant b) {
        this.restaurant1 = a;
        this.restaurant2 = b;
    }

    public Tuple process(Person[] people) {
        assert people.length > 0 : "O vetor passado não pode estar vazio.";

        if (!started)
            _total = new Tuple(people[0]);
        Tuple _total_local = new Tuple(people[0]);

        for (Person _person : people) {
            // Pedidos no restaurante 1
            int demanded = restaurant1.getNDemands(_person.getId());
            int total = demanded;

            if (!started)
                _rest1 = new Tuple(_person);

            if (demanded > _rest1.nDemands) {
                _rest1.nDemands = demanded;
                _rest1.person = _person;
            }

            System.out.printf("A pessoa <%s> fez %d pedidos no restaurant <%s>.\n",
                    _person.toString(), demanded, restaurant1.toString());

            // Pedidos no restaurante 2
            demanded = restaurant1.getNDemands(_person.getId());
            total += demanded;

            if (!started)
                _rest2 = new Tuple(_person);

            if (demanded > _rest2.nDemands) {
                _rest2.nDemands = demanded;
                _rest2.person = _person;
            }

            System.out.printf("A pessoa <%s> fez %d pedidos no restaurant <%s>.\n",
                    _person.toString(), demanded, restaurant2.toString());

            // Total
            System.out.printf("A pessoa <%s> fez %d pedidos no total.\n",
                    _person.toString(), total);

            if (total > _total_local.nDemands) {
                _total_local.nDemands = total;
                _total_local.person = _person;
            }
        }

        if (_total_local.nDemands > _total.nDemands) {
            _total.nDemands = _total_local.nDemands;
            _total.person = _total_local.person;
        }

        return _total_local;
    }

}
