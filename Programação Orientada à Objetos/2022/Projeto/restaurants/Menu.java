package restaurants;

import java.util.Collection;
import java.util.Hashtable;

/*
 * Menu
 * Registro de um único produto de restaurantes, usado para construção de um cardápio.
 */
public class Menu implements AutoCloseable {
    static private int lastId = 0;
    static private Menu lastInstance;

    private int id;
    private double value;
    private String product;
    private String description;
    private String image;
    // Restaurantes nos quais o menu está associado, e sua respectiva colocação no
    // cardápio.
    private Hashtable<Integer, Restaurant> restaurants;

    public Menu(String product, double value) {
        this.id = lastId++;
        this.value = value;
        this.product = product;
        this.restaurants = new Hashtable<Integer, Restaurant>();
        Menu.lastInstance = this;
    }

    public Menu(String product, double value, String description) {
        this(product, value);
        this.description = description;
    }

    public Menu(double value, String product, Restaurant[] restaurants) {
        this(product, value);

        for (Restaurant restaurant : restaurants)
            this.restaurants.put(restaurant.getId(), restaurant);
    }

    @Override
    public void close() throws Exception {
        // Para cada instância ao ser removida da memória,
        // desocupamos seu id para ser usada por outras instâncias.
        Menu.lastInstance.id = this.id;
        id--;
    }

    /* Verifica se este menu está presente no restaurante indicado. */
    public boolean isAt(Restaurant restaurant) {
        return restaurants.containsKey(restaurant.getId());
    }

    /*
     * Adiciona o menu ao restaurante determinado.
     * Retorna true se a adição for feita com sucesso.
     * Nota: apenas restaurants devem fazer a associação com os menus.
     */
    public boolean addTo(Restaurant restaurant) {
        boolean wasNotIn = !isAt(restaurant);

        if (wasNotIn)
            restaurants.put(restaurant.getId(), restaurant);

        return wasNotIn;
    }

    /*
     * Remove o menu do restaurante determinado.
     * Retorna true se a remoção for feita com sucesso.
     * Nota: apenas o próprio restaurante deve se desvincular do menu.
     */
    public boolean removeFrom(Restaurant restaurant) {
        boolean wasIn = isAt(restaurant);

        if (wasIn)
            restaurants.remove(restaurant.getId());

        return wasIn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Restaurant> getRestaurants() {
        return restaurants.values();
    }
    
    @Override
    public String toString() {
        if (description.isBlank())
            return String.format("%s (R$ %.2f)", product, value);
        else
            return String.format("%s (R$ %.2f), %s", product, value, description);
    }

}
