import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Arrays to store objects
        Customer[] customers = new Customer[100];
        Car[] cars = new Car[100];
        Rental[] rentals = new Rental[100];

        int customerCount = 0;
        int carCount = 0;
        int rentalCount = 0;

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Customer Menu");
            System.out.println("2. Car Menu");
            System.out.println("3. Rental Menu");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = input.nextInt();

            if (choice == 1) {
                customerCount = customerMenu(customers, customerCount, input); // Zachary's Part
            } else if (choice == 2) {
                carCount = carMenu(cars, carCount, input); // Aidan's Part
            } else if (choice == 3) {
                rentalMenu(rentals, rentalCount, input); // Mohammad's Part
            } else if (choice == 4) {
                System.out.println("Exiting Program...");
                break;
            } else {
                System.out.println("Invalid Option.");
            }
        }
    }

    // Zachary's Part - Customer Menu
    public static int customerMenu(Customer[] customers, int customerCount, Scanner input) {
        // To be completed by Zachary
        return customerCount;
    }

    // Aidan's Part - Car Menu
    public static int carMenu(Car[] cars, int carCount, Scanner input) {
        // To be completed by Aidan
        return carCount;
    }

    // Mohammad's Part - Rental Menu
    public static void rentalMenu(Rental[] rentals, int rentalCount, Scanner input) {
        while (true) { //to be completed by Mohammad
            System.out.println("\n--- Rental Menu ---");
            System.out.println("1. Add Rental");
            System.out.println("2. View Rentals by Customer License Number");
            System.out.println("3. View Rentals by Car VIN");
            System.out.println("4.")
}
    }
}