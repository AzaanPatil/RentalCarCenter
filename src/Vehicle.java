public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int rate;
    protected int gasMileage;

    public Vehicle(String brand, String model, int rate, int gasMileage) {
        this.brand = brand;
        this.model = model;
        this.rate = rate;
        this.gasMileage = gasMileage;
    }

    @Override
    public abstract String toString();
}
