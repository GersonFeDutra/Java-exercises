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

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Server extends UnicastRemoteObject implements IMessage {
    private static String IP = "127.0.0.1";
    private static String PORT = "11099";
    private ArrayList messages = new ArrayList<String>();

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
    public void addMessage(String m) throws RemoteException {
        messages.add(m);
    }

    @Override
    public String getDateTime() throws RemoteException {
        return (new SimpleDateFormat("YYYY-MM-DD HH:MM")).format(new Date());
    }

    @Override
    public String getIP() throws RemoteException {
        return IP;
    }

    @Override
    public ArrayList<String> getMessages() throws RemoteException {
        return messages;
    }
}
