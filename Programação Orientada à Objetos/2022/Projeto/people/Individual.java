package people;

import java.time.LocalDate;
import java.time.Period;

public class Individual extends Person {
    private String cpf;

    public Individual(String name, String cpf, LocalDate birth) {
        super(name, birth);
        this.cpf = cpf;
    }

    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
