package restaurants;

import people.Person;

/*
 * Demand
 * O pedido que está associado a uma pessoa.
 * O id se refere a um determinado id de um menu (produto) do restaurante.
 */
public class Demand {
    private int id;
    private Person owner;

    // Propriedade auxiliar para marcar o estado do pedido,
    // útil para economizar tempo de busca quando pedido for usado numa fila.
    enum State {
        NONE,
        ON_WAIT,
        ON_DELIVER,
    }

    private State state = State.NONE;

    public Demand(int id, Person owner) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
