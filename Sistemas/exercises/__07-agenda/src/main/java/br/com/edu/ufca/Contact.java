package br.com.edu.ufca;

public class Contact {

    public enum AddressType {
        RESIDENTIAL,
        COMERCIAL,
    }

    private int dbId = -1;
    private String name;
    private String email;
    private String phone;

    public String address = "";
    private final AddressType addressType;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressType = AddressType.RESIDENTIAL;
    }

    public Contact(String name, String email, String phone, AddressType addressType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressType = addressType;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setTelefone(String phone) {
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("Nome:\t" + name);
        System.out.println("Email:\t" + email);
        System.out.println("Fone:\t" + phone);

        if (!address.isBlank())
            System.out.printf("Endereço (%s):\t%s\n", addressType, address);
    }

    public int getId() {
        return this.dbId;
    }

    public void setId(int id) {
        this.dbId = id;
    }

    @Override
    public String toString() {
        return String.format("contact:%d", dbId);
    }
}
