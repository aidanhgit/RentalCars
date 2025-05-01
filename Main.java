import java.util.Scanner;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

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
        //Looping through customer menu until the user quits
        String options = "";
        do {
            options = JOptionPane.showInputDialog("Enter option or quit: \n\nA: Add Customer \nP: Update Phone Number \nL: Update License Number \nR: Remove Customer \nQ: Quit");
            switch(options){
                case "A":
                    try {
                        addCustomer(customers);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Only 100 customers can be tracked, please delete one or more customers to add another");
                    }
                    break;
                case "P":
                    updateCustomerPhone(customers);
                    break;
                case "L":
                    updateCustomerLicense(customers);
                case "R":
                    //to be completed by Zachary
                    break;
                case "Q":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter one of the 4 given choices");
                    break;
            }
        } while (!options.equals("Q"));
            return customerCount;
    }
    
    // Zachary's Part - Method to add a customer
    public static void addCustomer(Customer[] customer) {
        //Creating an Customer instance 
        Customer[] customer = new Customer();
        //Because these variables must be provided, each one loops if an exception is caught
        boolean restart = true;
        do {
            try {
                customer.setName(JOptionPane.showInputDialog("Enter customer name: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                customer.setDOB(JOptionPane.showInputDialog("Enter Date of Birth: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                customer.setPhone(JOptionPane.showInputDialog("Enter phone number: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                customer.setLicenseNum(JOptionPane.showInputDialog("Enter license number: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
    }

    // Zachary's Part - Method to update phone number
    public static void updateCustomerPhone(Customer[] customer) {
        String message = "";
        int sum = 0;
        //Loops through array of policies to create the message for display
        for (int i = 0 ; i<Customer.getNumCustomer();i++) {
                sum = 1 + i;
                message += sum + ".\n";
                message += customer[i].toString();
        }
        try {
            int options = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customer to update phone number\n\n" + message));
            if(options>0) {
                customer[options-1].setPhone(JOptionPane.showInputDialog("Enter phone number: "));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be a number");
        }
    }

    // Zachary's Part - Method to update license number
    public static void updateCustomerLicense(Customer[] customer) {
        String message = "";
        int sum = 0;
        //Loops through array of policies to create the message for display
        for (int i = 0 ; i<Customer.getNumCustomer();i++) {
                sum = 1 + i;
                message += sum + ".\n";
                message += customer[i].toString();
        }
        try {
            int options = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customer to update license number\n\n" + message));
            if(options>0) {
                customer[options-1].setLicenseNum(JOptionPane.showInputDialog("Enter license number: "));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be a number");
        }
    }

    // Aidan's Part - Car Menu
    public static int carMenu(Car[] cars, int carCount, Scanner input) {
        // To be completed by Aidan
        while (true) {
            String option = JOptionPane.showInputDialog("1. Add Car\n2. Remove Car\n3. Search Cars\n4. Display Cars\n5. Exit Car Menu");
            if (option == null || option.equals("5"))
                break;

            switch (option) {
                case "1":
                    addCar(cars, carCount);
                    break;
                case "2":
                    removeCar(cars, carCount);
                    break;
                case "3":
                    searchCars(cars, carCount);
                    break;
                case "4":
                    viewCars(cars, carCount);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entry invalid. Try again.");
            }
        }
        return carCount;
    }

    /**
     * Adds a new car to the collection.
     * 
     * @param cars List of all cars
     * @param carCount 
     */
    public static void addCar(Car[] cars, int carCount) {
        while (true) {
            try {
                String type = JOptionPane.showInputDialog("Enter vehicle type (Sedan/Sports/SUV)");
                if (type == null) return;

                String vin = JOptionPane.showInputDialog("Enter car VIN:");
                String make = JOptionPane.showInputDialog("Enter Model:");
                String model = JOptionPane.showInputDialog("Enter Model:");
                double MPG = Double.parseDouble(JOptionPane.showInputDialog("Enter MPG:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
                
                if (type.equalsIgnoreCase("Sedan")) {
                    boolean isLuxury = false;
                    if (JOptionPane.showConfirmDialog(null, "Is this a luxury Sedan?", "Luxury Car Check",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        isLuxury = true;
                    }
                    cars[carCount++] = new Sedan(vin, make, model, MPG, price, isLuxury);
                } else if (type.equalsIgnoreCase("Sports")) {
                    double premiumFee = Double.parseDouble(JOptionPane.showInputDialog("Enter premium fee:"));
                    cars[carCount++] = new Sports(vin, make, model, MPG, price, premiumFee);
                } else if (type.equalsIgnoreCase("SUV")) {
                    double gasGuzzlerFee = Double.parseDouble(JOptionPane.showInputDialog("Enter Gas Guzzler Fee Multiplier"));
                    cars[carCount++] = new SUV(vin, make, model, MPG, price, gasGuzzlerFee);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Vehicle Type")
                }
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nPlease try again.");
            }
        }
    }

    public static void removeCar(Car[] cars, int carCount) {
        String vin = JOptionPane.showInputDialog("Enter vin of vehicle to remove:");
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getVin().equals(vin)) {
                cars[i] = cars[--carCount];
                JOptionPane.showMessageDialog(null, "Car removed successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Car not found.");
    }

    public static void searchCars(Car[] cars, int carCount) {
        String vin = JOptionPane.showInputDialog("Enter vin to search for:");
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getVin().equals(vin)) {
                JOptionPane.showMessageDialog(null, cars[i].toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Car not found.");
    }

    public static void viewCars(Car[] cars, int carCount) {
        if (carCount == 0) {
            JOptionPane.showMessageDialog(null, "No cars available to view.");
            return;
        }
        String output = "Cars:\n";
        for (int i = 0; i < carCount; i++) {
            output += cars[i].toString() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }



    // Mohammad's Part - Rental Menu
  public static void rentalMenu(Rental[] rentals, int rentalCount, Scanner input) {
        while (true) {
            System.out.println("\n--- Rental Menu ---");
            System.out.println("1. Add Rental");
            System.out.println("2. View Rentals by Customer License Number");
            System.out.println("3. View Rentals by Car VIN");
            System.out.println("4. Exit Rental Menu");
            System.out.print("Choose option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            if (choice == 1) {
                if (rentalCount >= rentals.length) {
                    System.out.println("Cannot add more rentals.");
                    continue;
                }
                System.out.print("Enter Customer Name: ");
                String name = input.nextLine();
                System.out.print("Enter License Number: ");
                String license = input.nextLine();
                System.out.print("Enter Car VIN: ");
                String vin = input.nextLine();
                System.out.print("Enter Rental Date (MM/DD/YYYY): ");
                String date = input.nextLine();
                System.out.print("Enter Number of Days: ");
                int days = input.nextInt();

                rentals[rentalCount] = new Rental(name, license, vin, date, days);
                rentalCount++;
                System.out.println("Rental successfully added!");

            } else if (choice == 2) {
                System.out.print("Enter License Number: ");
                String license = input.nextLine();
                boolean found = false;
                for (int i = 0; i < rentalCount; i++) {
                    if (rentals[i].getLicenseNumber().equals(license)) {
                        System.out.println(rentals[i]);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No rentals found for this license number.");
                }

            } else if (choice == 3) {
                System.out.print("Enter Car VIN: ");
                String vin = input.nextLine();
                boolean found = false;
                for (int i = 0; i < rentalCount; i++) {
                    if (rentals[i].getVin().equals(vin)) {
                        System.out.println(rentals[i]);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No rentals found for this VIN.");
                }

            } else if (choice == 4) {
                System.out.println("Exiting Rental Menu...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
