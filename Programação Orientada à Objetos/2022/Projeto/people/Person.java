package people;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import restaurants.Demand;
import restaurants.Restaurant;

/*
 * Person
 * Classe base para qualquer cliente usuário da aplicação.
 */
public class Person {
    static protected int lastUsedID = 0;
    private int id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private LocalDate birthDate;
    // Armazena e associa os pedidos com o restaurante em que ele foi feito.
    private Hashtable<Demand, Restaurant> demands;
    private Hashtable<Restaurant, Hashtable<Integer, Demand>> demandsList;
    // Faz a associação inversa para facilitar a busca.

    public Person(String name, LocalDate birth) {
        this.id = lastUsedID++;
        this.name = name;
        this.birthDate = birth;
        this.demands = new Hashtable<Demand, Restaurant>();
        this.demandsList = new Hashtable<Restaurant, Hashtable<Integer, Demand>>();
    }

    /* Guarda um pedido feito em algum restaurante, associado à pessoa. */
    public void storeDemand(Demand demand, Restaurant restaurant) {
        this.demands.put(demand, restaurant);
        
        // Faz a associação inversa com listagem na Hash Table.
        Hashtable<Integer, Demand> demands = demandsList.getOrDefault(restaurant, null);
        
        if (demands == null) {
            demands = new Hashtable<Integer, Demand>();
            demandsList.put(restaurant, demands);
        }
        demands.put(restaurant.getId(), demand);
    }

    /* Remove um pedido associado a pessoa, retornando o restaurante em que foi feito. */
    public Restaurant cleanDemand(Demand demand) {

        // Desfaz a associação inversa da demanda.
        for (Hashtable<Integer, Demand> demands : demandsList.values())
            if (demands.remove(demand.getId()) != null)
                break;

        return demands.remove(demand);
    }
    
    public Collection<Demand> getRequestsAt(Restaurant restaurant) {
        Hashtable<Integer, Demand> demands = demandsList.getOrDefault(restaurant, null);

        if (demands == null)
            return null;

        return demands.values();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("[%d]: %s", this.id, this.name);
    }
}
