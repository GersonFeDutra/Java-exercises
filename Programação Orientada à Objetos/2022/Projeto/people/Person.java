package people;

import java.time.LocalDate;
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

    public Person(String name, LocalDate birth) {
        this.id = lastUsedID++;
        this.name = name;
        this.birthDate = birth;
    }

    /* Guarda um pedido feito em algum restaurante, associado à pessoa. */
    public void storeDemand(Demand demand, Restaurant restaurant) {
        demands.put(demand, restaurant);
    }

    /* Remove um pedido associado a pessoa, retornando o restaurante em que foi feito. */
    public Restaurant cleanDemand(Demand demand) {
        return demands.remove(demand);
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
