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

        String options = "";
        do {
            options = JOptionPane.showInputDialog(
                    "Enter option or quit: \n\nC: Customer Menu \nA: Car Menu \nR: Rental Menu \nQ: Quit");
            switch (options) {
                case "C":
                    customerCount = customerMenu(customers, customerCount, input); // Zachary's Part
                    break;
                case "A":
                    carCount = carMenu(cars, carCount, input); // Aidan's Part
                    break;
                case "R":
                    rentalMenu(rentals, rentalCount, input); // Mohammad's Part
                case "Q":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter one of the 4 given choices");
                    break;
            }
        } while (!options.equals("Q"));
    }

    // Zachary's Part - Customer Menu
    public static int customerMenu(Customer[] customers, int customerCount, Scanner input) {
        // Looping through customer menu until the user quits
        String options = "";
        do {
            options = JOptionPane.showInputDialog(
                    "Enter option or quit: \n\nA: Add Customer \nP: Update Phone Number \nL: Update License Number \nR: Remove Customer \nQ: Quit");
            switch (options) {
                case "A":
                    try {
                        customerCount = addCustomer(customers, customerCount);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null,
                                "Only 100 customers can be tracked, please delete one or more customers to add another");
                    }
                    break;
                case "P":
                    updateCustomerPhone(customers, customerCount);
                    break;
                case "L":
                    updateCustomerLicense(customers, customerCount);
                case "R":
                    customerCount = removeCustomer(customers, customerCount);
                    break;
                case "Q":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter one of the 5 given choices");
                    break;
            }
        } while (!options.equals("Q"));
        return customerCount;
    }

    // Zachary's Part - Method to add a customer
    public static int addCustomer(Customer[] customer, int customerCount) {
        // Creating an Customer instance
        Customer c = new Customer();
        // Because these variables must be provided, each one loops if an exception is
        // caught
        boolean restart = true;
        do {
            try {
                c.setName(JOptionPane.showInputDialog("Enter customer name: "));
                restart = false;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setDOB(JOptionPane.showInputDialog("Enter Date of Birth: "));
                restart = false;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setPhone(JOptionPane.showInputDialog("Enter phone number: "));
                restart = false;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setLicenseNum(JOptionPane.showInputDialog("Enter license number: "));
                restart = false;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        customer[customerCount] = c;
        return customerCount + 1;
    }

    // Zachary's Part - Method to update phone number
    public static void updateCustomerPhone(Customer[] customer, int customerCount) {
        String message = "";
        int sum = 0;
        //Loops through array of policies to create the message for display
        for (int i = 0 ; i<customerCount;i++) {
                sum = 1 + i;
                message += customerCount + ".\n";
                message += customer[i].toString() + "\n";
        }
        try {
            int options = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter the number of customer to update phone number\n\n" + message));
            if (options > 0 && customer[options - 1].getPhone() != null) {
                customer[options - 1].setPhone(JOptionPane.showInputDialog("Enter phone number: "));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be a number");
        }
    }

    // Zachary's Part - Method to update license number
    public static void updateCustomerLicense(Customer[] customer, int customerCount) {
        String message = "";
        int sum = 0;
        //Loops through array of policies to create the message for display
        for (int i = 0 ; i<customerCount;i++) {
                sum = 1 + i;
                message += sum + ".\n";
                message += customer[i].toString() + "\n";
        }
        try {
            int options = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter the number of customer to update license number\n\n" + message));
            if (options > 0 && customer[options - 1].getLicenseNum() != null) {
                customer[options - 1].setLicenseNum(JOptionPane.showInputDialog("Enter license number: "));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be a number");
        }
    }

    // Zachary's Part - Method to remove customer
    public static int removeCustomer(Customer[] customer, int customerCount) {
        String message = "";
        int sum = 0;
        //Loops through array of policies to create the message for display
        for (int i = 0 ; i<customerCount;i++) {
                sum = 1 + i;
                message += sum + ".\n";
                message += customer[i].toString() + "\n";
        }
        try {
            int options = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customer to remove\n\n" + message));
            if(options>0 && customer[options-1].getName() != null) {
                //Making object null at index to delete it
                customer[options-1] = null;
                //Shifting the policies to fill the space
                for(int i=options-1;i<customerCount;i++){
                    customer[i] = customer[i+1];
                }
                customerCount--;
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be a number");
        }
        return customerCount;
    }

    // Aidan's Part - Car Menu
    public static int carMenu(Car[] cars, int carCount, Scanner input) {
        // To be completed by Aidan
        while (true) {
            String option = JOptionPane
                    .showInputDialog("1. Add Car\n2. Remove Car\n3. Search Cars\n4. Display Cars\n5. Exit Car Menu");
            if (option == null || option.equals("5"))
                break;

            switch (option) {
                case "1":
                    carCount = addCar(cars, carCount);
                    break;
                case "2":
                    carCount = removeCar(cars, carCount);
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
     * @param cars     List of all cars
     * @param carCount
     */
    public static int addCar(Car[] cars, int carCount) {
        while (true) {
            try {
                String type = JOptionPane.showInputDialog("Enter vehicle type (Sedan/Sports/SUV)");
                if (type == null)
                    return carCount;

                String vin = JOptionPane.showInputDialog("Enter car VIN:");
                String make = JOptionPane.showInputDialog("Enter Make:");
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
                    return carCount;
                } else if (type.equalsIgnoreCase("Sports")) {
                    double premiumFee = Double.parseDouble(JOptionPane.showInputDialog("Enter premium fee:"));
                    cars[carCount++] = new Sports(vin, make, model, MPG, price, premiumFee);
                    return carCount;
                } else if (type.equalsIgnoreCase("SUV")) {
                    double gasGuzzlerFee = Double
                            .parseDouble(JOptionPane.showInputDialog("Enter Gas Guzzler Fee Multiplier"));
                    cars[carCount++] = new SUV(vin, make, model, MPG, price, gasGuzzlerFee);
                    return carCount;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Vehicle Type");
                }
                return carCount;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nPlease try again.");
            }
        }
    }

    public static int removeCar(Car[] cars, int carCount) {
        String vin = JOptionPane.showInputDialog("Enter vin of vehicle to remove:");
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getVin().equals(vin)) {
                cars[i] = cars[--carCount];
                JOptionPane.showMessageDialog(null, "Car removed successfully.");
                return carCount;
            }
        }
        JOptionPane.showMessageDialog(null, "Car not found.");
        return carCount;
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
        // Display menu to the user using JOptionPane
        String menu = "--- Rental Menu ---\n"
                    + "1. Add Rental\n"
                    + "2. View Rentals by Customer License Number\n"
                    + "3. View Rentals by Car VIN\n"
                    + "4. Exit Rental Menu\n\n"
                    + "Choose option:";
        String choiceStr = JOptionPane.showInputDialog(null, menu);
        if (choiceStr == null) {
            JOptionPane.showMessageDialog(null, "Exiting Rental Menu...");
            break;
        }

        int choice = Integer.parseInt(choiceStr);

        // Option 1: Add a new rental to the system
        if (choice == 1) {
            if (rentalCount >= rentals.length) {
                JOptionPane.showMessageDialog(null, "Cannot add more rentals.");
                continue;
            }

            // Prompt user for rental details using dialog boxes
            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            String license = JOptionPane.showInputDialog("Enter License Number:");
            String vin = JOptionPane.showInputDialog("Enter Car VIN:");
            String date = JOptionPane.showInputDialog("Enter Rental Date (MM/DD/YYYY):");
            String daysStr = JOptionPane.showInputDialog("Enter Number of Days:");

            if (name == null || license == null || vin == null || date == null || daysStr == null) {
                JOptionPane.showMessageDialog(null, "Rental creation canceled.");
                continue;
            }

            int days = Integer.parseInt(daysStr);

            rentals[rentalCount] = new Rental(name, license, vin, date, days);
            rentalCount++;
            JOptionPane.showMessageDialog(null, "Rental successfully added!");

        // Option 2: Search and Display rentals for a specific customer
        } else if (choice == 2) {
            String license = JOptionPane.showInputDialog("Enter License Number:");
            if (license == null) continue;

            boolean found = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < rentalCount; i++) {
                if (rentals[i].getLicenseNumber().equals(license)) {
                    result.append(rentals[i].toString()).append("\n\n");
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, result.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No rentals found for this license number.");
            }

        // Option 3: Search and display rentals for a specific car VIN
        } else if (choice == 3) {
            String vin = JOptionPane.showInputDialog("Enter Car VIN:");
            if (vin == null) continue;

            boolean found = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < rentalCount; i++) {
                if (rentals[i].getVin().equals(vin)) {
                    result.append(rentals[i].toString()).append("\n\n");
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, result.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No rentals found for this VIN.");
            }

        // Option 4: Exit the rental menu loop and return to the main menu
        } else if (choice == 4) {
            JOptionPane.showMessageDialog(null, "Exiting Rental Menu...");
            break;

        // Handle invalid input
        } else {
            JOptionPane.showMessageDialog(null, "Invalid option.");
        }
    }
}
