public class Rental {

    // Aggregated Objects (references to existing objects)
    private Customer customer;  // Aggregation: links to an existing Customer
    private Car car;            // Aggregation: links to an existing Car

    private String rentalDate;
    private int rentalDays;

    private static int numRental = 0;

    // Constructor requires existing Customer and Car objects
    public Rental(Customer customer, Car car, String rentalDate, int rentalDays) {
        this.customer = customer;   
        this.car = car;             
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        numRental++;
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public static int getNumRental() {
        return numRental;
    }

    // Setters (if needed)
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays > 0) {
            this.rentalDays = rentalDays;
        } else {
            System.out.println("Invalid number of rental days.");
        }
    }

    // Method to update rental count
    public void updateNumRental() {
        numRental--;
    }

    // toString for displaying rental info
    public String toString() {
        return "Rental Details:\n"
             + "Customer Info:\n" + customer.toString() + "\n"
             + "Car Info:\n" + car.toString() + "\n"
             + "Rental Date: " + rentalDate + "\n"
             + "Rental Days: " + rentalDays + "\n";
    }
}
