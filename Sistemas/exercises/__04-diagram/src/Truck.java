public class Truck extends Vehicle {
    private int axis;

    public Truck(String licensePlate, int year, int axis) {
        super(licensePlate, year);
        this.axis = axis;
    }

    public int getAxis() {
        return axis;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.printf("\tNumber of axis: %d\n", this.axis);
    }

    @Override
    public void accelerate() {
        System.out.println("Uoooonn, fffvuuurronnn! Accelerating truck!");
    }

}
