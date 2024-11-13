package br.com.edu.ufca.contacts;

import java.math.BigDecimal;

import br.com.edu.ufca.Contact;

public class LegalEntity extends Contact {
    // public String corporateName;
    public String cnpj;
    public BigDecimal invoicing;

    public LegalEntity(String corporateName, String email, String phone, String cnpj) {
        super(corporateName, email, phone, AddressType.COMERCIAL);
        this.cnpj = cnpj;
        invoicing = new BigDecimal(0d);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("CNPJ:\t" + cnpj);
        System.out.println("Faturamento:\t" + invoicing);
    }

}
