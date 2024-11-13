```java
/**
 * Faça um programa de agenda telefônica, com as classes Agenda e Contato.
 * A agenda permite guardar dois tipos de contato: pessoa física e pessoa
 * jurídica.
 *
 * Para pessoa física, guarde o nome, o CPF, o endereço e a data de aniversário.
 * Para pessoa jurídica, guarde a razão social, o CNPJ, o endereço e o
 * faturamento.
 *
 * Permita tanto listar todos os contatos da agenda quanto buscar um contato
 * específico pelo seu CPF, se for pessoa física, ou pelo CNPJ, se for pessoa
 * jurídica. Use herança e polimorfismo.
 *
 * a) Adicione a funcionalidade de exibição do total de contatos registrados na
 * agenda;
 * b) Adicione a funcionalidade de busca por contato na agenda;
 * c) Adicione o registro de endereço comercial e residencial por contato;
 * d) Liste os contatos ordenados por nome e por idade. Dica: Podemos usar o
 * Comparator;
 * e) Faça uma classe abstrata Ordenador com a lógica de ordenação, porém
 * chamando um método abstrato compara(Pessoa, Pessoa);
 * f) Criar duas classes extras, OrdenadorNome e OrdenadorIdade, que herdam de
 * Ordenador e implementam o método abstrato compara(Pessoa, Pessoa);
 * g) Instanciar o ordenador apropriado para listar os contatos por nome e por
 * idade.
 */

```

```java
package br.com.edu.ufca.aps.revisao07;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<Contato>();
    }

    public boolean addContato(Contato novoContato) {
        System.out.println("Contato adicionado");
        return contatos.add(novoContato);
    }

    public boolean removeContato(Contato contato) {
        System.out.println("Contato removido");
        return contatos.remove(contato);
    }

    public void exibirContatos() {
        for (Contato c : contatos) {
            c.mostrarInformacoes();
        }
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }
}

```

```java
package br.com.edu.ufca.aps.revisao07;

public class Contato {

    private String nome;
    private String email;
    private String telefone;

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Fone: " + telefone);
    }
}

```

```java
package br.com.edu.ufca.aps.revisao07;

import java.util.Collections;

public class TestaAgenda {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Contato c1 = new Contato("Fabio", "fabio.silva@gmail.com", "(83) 98765.0987");
        Contato c2 = new Contato("Patricia", "patricia.santos@gmail.com", "(88) 99087.0987");
        Contato c3 = new Contato("Ana", "ana_098@gmail.com", "(83) 98765.0987");
        Contato c4 = new Contato("Rafael", "rafael18@gmail.com", "(88) 99087.0987");

        Agenda minhaAgenda = new Agenda();

        minhaAgenda.addContato(c1);
        minhaAgenda.addContato(c2);
        minhaAgenda.addContato(c3);
        minhaAgenda.addContato(c4);

        minhaAgenda.exibirContatos();

        // minhaAgenda.removeContato(c2);

        // minhaAgenda.exibirContatos();

        System.out.println("Lista ordenada por nome crescente");
        Collections.sort(minhaAgenda.getContatos(), new ComparatorNomeCrescente());
        minhaAgenda.exibirContatos();

        System.out.println("Lista ordenada por nome decrescente");
        Collections.sort(minhaAgenda.getContatos(), new ComparatorNomeDecrescente());
        minhaAgenda.exibirContatos();
    }

}

```

```java
package br.com.edu.ufca.aps.revisao07;

import java.util.Comparator;
import br.com.edu.ufca.aps.revisao07.Contato;

public class ComparatorNomeCrescente implements Comparator<Contato> {

	@Override
	public int compare(Contato contato1, Contato contato2) {
		// TODO Auto-generated method stub
		if (contato1.getNome().compareTo(contato2.getNome()) > 0) {
			// o contato 1 vem antes do contato 2
			return 1;
		}
		// o contato 2 vem antes do contato 1
		return -1;
	}
}

```

```java
package br.com.edu.ufca.aps.revisao07;

import java.util.Comparator;
import br.com.edu.ufca.aps.revisao07.Contato;

public class ComparatorNomeDecrescente implements Comparator<Contato> {

    @Override
    public int compare(Contato contato1, Contato contato2) {
        // TODO Auto-generated method stub
        if (contato1.getNome().compareTo(contato2.getNome()) > 0) {
            // o contato 1 vem antes do contato 2
            return -1;
        }
        // o contato 2 vem antes do contato 1
        return 1;
    }

}

```
