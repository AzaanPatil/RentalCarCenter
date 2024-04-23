import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalCenter implements Rentable {
    private ArrayList<Vehicle> inventory;
    private ArrayList<Vehicle> rentedCars;
    private final File inventoryFile;

    public RentalCenter(String inventoryFilePath) {
        inventory = new ArrayList<>();
        rentedCars = new ArrayList<>();
        inventoryFile = new File(inventoryFilePath);
        loadInventory();
    }

    @Override
    public void rentVehicle(int choice) {
        if (choice < 0 || choice >= inventory.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        if (inventory.size() <= 3) {
            System.out.println("You have reached your renting limit");
            return;
        }
        Vehicle vehicle = inventory.remove(choice);
        rentedCars.add(vehicle);
        System.out.println("Vehicle rented: " + vehicle);
    }

    @Override
    public void returnVehicle(int index) {
        if (index < 0 || index >= rentedCars.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        if (rentedCars.size() >= 7) {
            System.out.println("You have reached your renting limit");
            return;
        }
        Vehicle vehicle = rentedCars.remove(index);
        inventory.add(vehicle);
        System.out.println("Vehicle returned: " + vehicle);
    }

    private void loadInventory() {
        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                String brand = parts[0];
                String model = parts[1];
                int rate = Integer.parseInt(parts[2]);
                int gasMileage = Integer.parseInt(parts[3]);
                Car car = new Car(brand, model, rate, gasMileage);
                inventory.add(car);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found: " + inventoryFile);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Error reading inventory. Check file format.");
            System.exit(2);
        }
    }

    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i));
        }
    }

    public void displayRentedCars() {
        if (rentedCars.isEmpty()) {
            System.out.println("You haven't rented any cars yet");
        } else {
            for (int i = 0; i < 7; i++) {
                System.out.println(i + ": " + rentedCars.get(i));
            }
        }
    }
}
