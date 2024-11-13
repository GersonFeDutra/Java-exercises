/* Exercício 4 - Implemente conforme o diagrama de classes. */
public class App {
    public static void main(String[] args) throws Exception {
        Bus bus = new Bus("0F-AB-02", 2016, 22);
        Truck truck = new Truck("FF-00-12", 2014, 4);

        bus.showData();
        bus.accelerate();
        truck.showData();
        truck.accelerate();
    }
}
