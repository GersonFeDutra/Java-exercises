package br.com.edu.ufca;

public class ProductEntry {
    public String name;

    private int quantity = 0;
    private double price = 0d;
    private double total = quantity * price;

    public ProductEntry(String name) {
        this.name = name;
    }

    public ProductEntry(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotal();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        updateTotal();
    }

    public double getTotal() {
        return total;
    }

    public void updateTotal() {
        this.total = price * quantity;
    }
}
