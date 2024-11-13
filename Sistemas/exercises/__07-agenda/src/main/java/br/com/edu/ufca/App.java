package br.com.edu.ufca;

/**
 * App
 *
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
 * jurídica. Use herança e polimorfismo
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
public class App {
    // public static void main(String[] args) {
    //     System.out.println("Hello World!");
    // }
}
