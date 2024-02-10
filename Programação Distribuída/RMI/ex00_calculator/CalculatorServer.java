import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements Calculator {

    public CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public float sum(float a, float b) throws RemoteException {
        return(a + b);
    }

    @Override
    public float sub(float a, float b) throws RemoteException {
        return(a - b);
    }

    @Override
    public float mul(float a, float b) throws RemoteException {
        return(a * b);
    }

    @Override
    public float div(float a, float b) throws RemoteException {
        return (a / b);
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            System.out.println("CalculatorServer is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new CalculatorServer());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

}
