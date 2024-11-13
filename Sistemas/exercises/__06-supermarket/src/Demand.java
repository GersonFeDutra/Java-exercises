import java.util.ArrayList;

public class Demand {
    private double totalPrice;
    private ArrayList<Item> items;

    public Demand() {
        items = new ArrayList<Item>();
    }

    public Demand(Item[] items) {
        this();

        for (Item item : items)
            addItem(item);
    }

    // TODO -> Remove item, Get item, Set item, Add Items, Clear...
    public void addItem(Item item) {
        items.add(item);
        this.totalPrice += item.getPrice();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    void consume() throws InvalidQuantityException {

        for (Item item : items)
            item.consume();

        this.items.clear();
    }

}
