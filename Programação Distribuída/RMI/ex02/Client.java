/*
Escreva um programa cliente/servidor, utilizando Java RMI em que:

Servidor:
    Deve oferecer um serviço para conversão de moedas, Euro para Real,
    Real Para Euro, Dólar para Real e Real para Dólar. 

Cliente:
    Solicitar uma conversão ao servidor.

PS. Utilize os valores das moedas no dia da sua implementação.
*/

import java.rmi.Naming;

public class Client {
    private static IMoney m = null;
    public static void main(String args[]) {
        try {
            m = (IMoney) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");

            double real, euro, dollar;
            real = 3.0;

            dollar = m.realToDollar(real);
            System.out.printf("Converting %.3f real to dollar: %.3f\n", real, dollar);

            // dollar *= Math.PI;
            real = m.dollarToReal(dollar);
            System.out.printf("Converting %.3f dollar to real: %.3f\n", dollar, real);

            euro = m.realToEuro(real);
            System.out.printf("Converting %.3f real to euro: %.3f\n", real, euro);

            // euro *= Math.PI;
            real = m.euroToReal(euro);
            System.out.printf("Converting %.3f euro to real: %.3f\n", euro, real);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
