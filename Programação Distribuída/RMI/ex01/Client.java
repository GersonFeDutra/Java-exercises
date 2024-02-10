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

public class Client {
    private static IMessage m = null;
    public static void main(String args[]) {
        try {
            m = (IMessage) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            String message = "hello";

            System.out.printf("Connecting to the server IP %s at %s\n", m.getIP(), m.getDateTime());

            System.out.printf("Sending message %s...\n", message);
            m.addMessage(message);

            message = "world";
            System.out.printf("Sending message %s...\n", message);
            m.addMessage(message);

            System.out.printf("Messages sent:\n");

            for (String sent : m.getMessages())
                System.out.println(sent);

            System.out.printf("Exiting communication with server at %s\n", m.getDateTime());

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
