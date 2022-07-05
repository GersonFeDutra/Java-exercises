package people;

import java.time.LocalDate;

public class LegalPerson extends Person {
    private String cnpj;

    public LegalPerson(String name, LocalDate birth) {
        super(name, birth);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
