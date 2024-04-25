import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a RentalCenter object, initializing it with the path to the rental inventory file
        RentalCenter rentalCenter = new RentalCenter("C:\\Users\\azaan\\IdeaProjects\\RentlCarCompSci\\src\\rentalInventory.txt");

        // Display welcome message
        System.out.println("Welcome to firstRent Car Rentals!");

        // Main program loop
        while (true) {
            // Display menu options
            System.out.println("1: Rent Car");
            System.out.println("2: Return Rented Car");
            System.out.println("3: Display Inventory");
            System.out.println("4: Display Rented Cars");
            System.out.println("5: Exit");

            // Variable to store user's choice
            int choice;
            try {
                // Read user input for choice
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Catch if input is not an integer
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input
                continue; // Restart the loop
            }

            // Switch statement to execute user's choice
            switch (choice) {
                case 1:
                    // Display inventory and prompt user to select a car to rent
                    rentalCenter.displayInventory();
                    System.out.println("Select the car you want to rent:");
                    int rentChoice = scanner.nextInt();
                    // Rent the selected car
                    rentalCenter.rentVehicle(rentChoice);
                    break;
                case 2:
                    // Display rented cars and prompt user to select a car to return
                    rentalCenter.displayRentedCars();
                    System.out.println("Select the car you want to return:");
                    int returnChoice = scanner.nextInt();
                    // Return the selected car
                    rentalCenter.returnVehicle(returnChoice);
                    break;
                case 3:
                    // Display the current inventory of cars
                    rentalCenter.displayInventory();
                    break;
                case 4:
                    // Display the cars currently rented out
                    rentalCenter.displayRentedCars();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Thank you for visiting!");
                    scanner.close(); // Close the scanner to prevent resource leak
                    System.exit(0); // Exit the program
                default:
                    // Display error message for invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
