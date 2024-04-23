public class Car extends Vehicle {

    public Car(String brand, String model, int rate, int gasMileage) {
        super(brand, model, rate, gasMileage);
    }

    @Override
    public String toString() {
        return brand + " " + model + ", Cost: $" + rate + " per day, Fuel Economy: " + gasMileage + " miles";
    }
}
