package br.com.edu.ufca.contacts;

import java.time.LocalDateTime;

import br.com.edu.ufca.Contact;

public class Individual extends Contact {

    public final LocalDateTime birthDate;
    public String cpf;

    public Individual(String name, String email, String phone, String cpf, LocalDateTime birth) {
        super(name, email, phone, AddressType.RESIDENTIAL);
        this.birthDate = birth;
        this.cpf = cpf;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("CPF:\t" + cpf);

        System.out.printf("Aniversário:\t %2d/%02d\n",
                birthDate.getDayOfMonth(), birthDate.getMonthValue());
    }

}
