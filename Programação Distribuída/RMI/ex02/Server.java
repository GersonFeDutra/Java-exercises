/*
Escreva um programa cliente/servidor, utilizando Java RMI em que:

Servidor:
    Deve oferecer um serviço para conversão de moedas, Euro para Real,
    Real Para Euro, Dolar para Real e Real para Dolar. 

Cliente:
    Solicitar uma conversão ao servidor.

PS. Utilize os valores das moedas no dia da sua implementação.
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IMoney {
    public static final double REAL = 1.0;
    public static final double DOLLAR = 0.202;
    public static final double EURO = 0.187;
    public static final String IP = "127.0.0.1";
    public static final int PORT = 11099;

    public Server() throws RemoteException {
        super();
    }

    public static void main(String args[]) {
        try {
            Server server = new Server();
            System.out.println("Server is running...");
            Naming.rebind(String.format("rmi://%s:%s/RMIInterface", IP, PORT), server);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public double euroToReal(double from) throws RemoteException {
        return from * (REAL / EURO);
    }

    @Override
    public double realToEuro(double from) throws RemoteException {
        return from * (EURO / REAL);
    }

    @Override
    public double dollarToReal(double from) throws RemoteException {
        return from * (REAL / DOLLAR);
    }

    @Override
    public double realToDollar(double from) throws RemoteException {
        return from * (DOLLAR / REAL);
    }
}
