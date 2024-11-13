import java.time.LocalDate;

/**
 * Vehicle
 */
public abstract class Vehicle {
    private String licensePlate;
    private final int year;

    public Vehicle() {
        this.licensePlate = "Null";
        this.year = LocalDate.now().getYear();
    }

    public Vehicle(String licensePlate, int year) {
        this.licensePlate = licensePlate;
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void showData() {
        System.out.printf("Vehicle [%s] year %d\n",
                this.licensePlate, this.year);
    }

    public abstract void accelerate();
}
