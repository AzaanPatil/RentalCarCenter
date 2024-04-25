// Class representing a car, extending the Vehicle class
public class Car extends Vehicle {

    // Constructor to initialize a car with brand, model, rate, and gas mileage
    public Car(String brand, String model, int rate, int gasMileage) {
        // Call the constructor of the superclass (Vehicle) to initialize attributes
        super(brand, model, rate, gasMileage);
    }

    // Method to provide a string representation of the car
    @Override
    public String toString() {
        // Format the car details into a string
        return brand + " " + model + ", Cost: $" + rate + " per day, Fuel Economy: " + gasMileage + " miles";
    }
}
