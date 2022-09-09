package people;

import java.time.LocalDate;

/* 
 * LegalPerson
 * Uma pessoa jurídica: contém cnpj.
 */
public class LegalPerson extends Person {
    private String cnpj;

    public LegalPerson(String name, String cnpj, LocalDate birth) {
        super(name, birth);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + ", cnpj: " + this.cnpj;
    }
}
