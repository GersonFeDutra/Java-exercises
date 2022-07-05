package restaurants;

public class Ticket {
    private int id;
    
    // O ticket provavelmente terá um pedido (prato) associado.
    public Ticket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
