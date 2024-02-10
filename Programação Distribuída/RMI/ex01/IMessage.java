/*
Escreva um programa cliente/servidor, utilizando Java RMI em que:
O servidor deve implementar uma lista para armazenamento de mensagens;

- Disponibilizar funções remotas para:
   - Armazenar uma string na lista;
   - Recuperar lista de mensagens;
   - Retornar o IP do servidor;
   - Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM

Cliente
- Invocar as funções remotas do servidor implementado.

Enviar o link dos arquivos cliente.py e servidor.py de um repositório git.
*/

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IMessage extends Remote {
    public ArrayList<String> getMessages() throws RemoteException;
    public void addMessage(String m) throws RemoteException;

    public String getIP() throws RemoteException;
    public String getDateTime() throws RemoteException;
}
