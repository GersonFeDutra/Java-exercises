import java.rmi.Naming;

public class CalculatorClient  {
    private static Calculator calc = null;

    public static void main(String[] args) {
        try {
            calc = (Calculator) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            System.out.println(String.valueOf(calc.sum(4, 3)));
        }
        catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public CalculatorClient() {
        super();
    }
}
