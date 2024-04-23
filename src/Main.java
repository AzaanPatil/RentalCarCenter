import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalCenter rentalCenter = new RentalCenter("C:\\Users\\azaan\\IdeaProjects\\RentlCarCompSci\\src\\rentalInventory.txt");

        System.out.println("Welcome to University Car Rentals!");

        while (true) {
            System.out.println("1: Rent Car");
            System.out.println("2: Return Rented Car");
            System.out.println("3: Display Inventory");
            System.out.println("4: Display Rented Cars");
            System.out.println("5: Exit");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    rentalCenter.displayInventory();
                    System.out.println("Select the car you want to rent:");
                    int rentChoice = scanner.nextInt();
                    rentalCenter.rentVehicle(rentChoice);
                    break;
                case 2:
                    rentalCenter.displayRentedCars();
                    System.out.println("Select the car you want to return:");
                    int returnChoice = scanner.nextInt();
                    rentalCenter.returnVehicle(returnChoice);
                    break;
                case 3:
                    rentalCenter.displayInventory();
                    break;
                case 4:
                    rentalCenter.displayRentedCars();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
