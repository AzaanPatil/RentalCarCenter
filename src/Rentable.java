// Interface defining methods for renting and returning vehicles
public interface Rentable {
    // Method to rent a vehicle based on the user's choice
    void rentVehicle(int choice);

    // Method to return a rented vehicle based on its index
    void returnVehicle(int index);
}
