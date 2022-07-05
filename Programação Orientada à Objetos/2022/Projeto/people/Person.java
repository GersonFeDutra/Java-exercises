package people;

import java.time.LocalDate;

import restaurants.Ticket;

public class Person {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private LocalDate birthDate;
    private Ticket ticket;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birthDate = birth;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    @Override
    public String toString() {
        return String.format("[%d]: %s", this.id, this.name);
    }
}
