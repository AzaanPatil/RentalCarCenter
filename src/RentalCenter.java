import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalCenter implements Rentable {
    // ArrayList to store the inventory of available vehicles
    private ArrayList<Vehicle> inventory;
    // ArrayList to store the vehicles currently rented out
    private ArrayList<Vehicle> rentedCars;
    // File object representing the inventory file
    private final File inventoryFile;

    // Constructor to initialize RentalCenter with the path to the inventory file
    public RentalCenter(String inventoryFilePath) {
        // Initialize inventory and rentedCars ArrayLists
        inventory = new ArrayList<>();
        rentedCars = new ArrayList<>();
        // Create a File object with the given inventory file path
        inventoryFile = new File(inventoryFilePath);
        // Load the inventory from the file
        loadInventory();
    }

    // Method to rent a vehicle based on the user's choice
    @Override
    public void rentVehicle(int choice) {
        // Check if the choice is within the bounds of the inventory ArrayList
        if (choice < 0 || choice >= inventory.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        // Check if the number of rented cars exceeds a limit
        if (inventory.size() <= 3) {
            System.out.println("You have reached your renting limit");
            return;
        }
        // Remove the selected vehicle from inventory and add it to rentedCars ArrayList
        Vehicle vehicle = inventory.remove(choice);
        rentedCars.add(vehicle);
        System.out.println("Vehicle rented: " + vehicle);
    }

    // Method to return a rented vehicle based on its index
    @Override
    public void returnVehicle(int index) {
        // Check if the index is within the bounds of the rentedCars ArrayList
        if (index < 0 || index >= rentedCars.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        // Remove the selected vehicle from rentedCars and add it back to inventory
        Vehicle vehicle = rentedCars.remove(index);
        inventory.add(vehicle);
        System.out.println("Vehicle returned: " + vehicle);
    }

    // Method to load the inventory from the inventory file
    private void loadInventory() {
        try (Scanner scanner = new Scanner(inventoryFile)) {
            // Read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line into parts using comma and space as delimiter
                String[] parts = line.split(", ");
                // Extract the details of the vehicle
                String brand = parts[0];
                String model = parts[1];
                int rate = Integer.parseInt(parts[2]);
                int gasMileage = Integer.parseInt(parts[3]);
                // Create a Car object with the extracted details and add it to inventory
                Car car = new Car(brand, model, rate, gasMileage);
                inventory.add(car);
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("Inventory file not found: " + inventoryFile);
            System.exit(1); // Exit the program with error code 1
        } catch (NumberFormatException e) {
            // Handle number format exception (e.g., if rate or gasMileage cannot be parsed as integers)
            System.out.println("Error reading inventory. Check file format.");
            System.exit(2); // Exit the program with error code 2
        }
    }

    // Method to display the current inventory of available vehicles
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i));
        }
    }

    // Method to display the vehicles currently rented out
    public void displayRentedCars() {
        if (rentedCars.isEmpty()) {
            System.out.println("You haven't rented any cars yet");
        } else {
            for (int i = 0; i < rentedCars.size(); i++) {
                System.out.println(i + ": " + rentedCars.get(i));
            }
        }
    }
}