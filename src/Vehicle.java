// Abstract class representing a vehicle
public abstract class Vehicle {
    // Attributes of a vehicle: brand, model, rate, and gas mileage
    protected String brand;
    protected String model;
    protected int rate;
    protected int gasMileage;

    // Constructor to initialize the vehicle with brand, model, rate, and gas mileage
    public Vehicle(String brand, String model, int rate, int gasMileage) {
        this.brand = brand;
        this.model = model;
        this.rate = rate;
        this.gasMileage = gasMileage;
    }

    // Abstract method to be implemented by subclasses to provide custom string representation
    @Override
    public abstract String toString();
}
