import java.util.Scanner;
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
            options = JOptionPane.showInputDialog("Enter option or quit: \n\nC: Customer Menu \nA: Car Menu \nR: Rental Menu \nQ: Quit");
            switch(options){
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
        //Looping through customer menu until the user quits
        String options = "";
        do {
            options = JOptionPane.showInputDialog("Enter option or quit: \n\nA: Add Customer \nP: Update Phone Number \nL: Update License Number \nR: Remove Customer \nQ: Quit");
            switch(options){
                case "A":
                    try {
                        customerCount = addCustomer(customers, customerCount);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Only 100 customers can be tracked, please delete one or more customers to add another");
                    }
                    break;
                case "P":
                    updateCustomerPhone(customers, customerCount);
                    break;
                case "L":
                    updateCustomerLicense(customers, customerCount);
                case "R":
                    //to be completed by Zachary
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
        //Creating an Customer instance
        Customer c = new Customer();
        //Because these variables must be provided, each one loops if an exception is caught
        boolean restart = true;
        do {
            try {
                c.setName(JOptionPane.showInputDialog("Enter customer name: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setDOB(JOptionPane.showInputDialog("Enter Date of Birth: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setPhone(JOptionPane.showInputDialog("Enter phone number: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (restart);
        restart = true;
        do {
            try {
                c.setLicenseNum(JOptionPane.showInputDialog("Enter license number: "));
                restart = false;
            }
            catch (IllegalArgumentException e) {
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
                message += sum + ".\n";
                message += customer[i].toString();
        }
        try {
            int options = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customer to update phone number\n\n" + message));
            if(options>0 && customer[options-1].getPhone() != null) {
                customer[options-1].setPhone(JOptionPane.showInputDialog("Enter phone number: "));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        } catch(NumberFormatException e) {
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
                message += customer[i].toString();
        }
        try {
            int options = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of customer to update license number\n\n" + message));
            if(options>0 && customer[options-1].getLicenseNum() != null) {
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
        return carCount;
    }

    // Mohammad's Part - Rental Menu
  public static void rentalMenu(Rental[] rentals, int rentalCount, Scanner input) {
        while (true) {
            System.out.println("\n--- Rental Menu ---");
            System.out.println("1. Add Rental");
            System.out.println("2. View Rentals by Customer License Number");
            System.out.println("3. View Rentals by Car VIN");
            System.out.println("4.");
        }
    }
}
