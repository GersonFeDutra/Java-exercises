/*
Escreva um programa cliente/servidor, utilizando Java RMI em que:

Servidor:
    Deve oferecer um serviço para conversão de moedas, Euro para Real,
    Real Para Euro, Dólar para Real e Real para Dólar.

Cliente:
    Solicitar uma conversão ao servidor.

PS. Utilize os valores das moedas no dia da sua implementação.
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMoney extends Remote {
    public double euroToReal(double from) throws RemoteException;
    public double realToEuro(double from) throws RemoteException;
    public double dollarToReal(double from) throws RemoteException;
    public double realToDollar(double from) throws RemoteException;
}
