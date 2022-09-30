package br.com.edu.ufca;

import br.com.edu.ufca.travel.*;
import br.com.edu.ufca.travel.destiny.Cruise;
import br.com.edu.ufca.travel.pack.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Agency agency = new Agency();

        TravelPackage[] packs = {
                new DrinkPackage("Pacote extra com bebidas quentes e frias inclusas."),
                new SpaPackage("Pacote com seções de massagem inclusas."),
                new TripPackage("Pacote com passeio turístico adicional."),
        };

        agency.defineTravel(new Cruise(
                "Cruzeiro de 1 semana, com as seguintes seções disponíveis: piscina, sauna, salão de festas e de jogos."),
                packs);

        System.out.printf("[R$ %.2f] %s",
                agency.getTotalPrice(), agency.getTravelDescription());
    }
}
