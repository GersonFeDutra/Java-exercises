import java.rmi.*;

public interface Calculator extends Remote {
    public float sum(float a, float b) throws RemoteException;
    public float sub(float a, float b) throws RemoteException;
    public float mul(float a, float b) throws RemoteException;
    public float div(float a, float b) throws RemoteException;
}
