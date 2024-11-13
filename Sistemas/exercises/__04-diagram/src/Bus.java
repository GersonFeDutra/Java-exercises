public class Bus extends Vehicle {
    private int seats;

    public Bus(String licensePlate, int year, int seats) {
        super(licensePlate, year);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.printf("\tNumber of seats: %d\n", this.seats);
    }

    @Override
    public void accelerate() {
        System.out.println("Unnnn, fvuuon! Accelerating bus!");
    }

}
