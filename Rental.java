public class Rental {

    // Instance Variables
    private String customerName;
    private String licenseNumber;
    private String vin;
    private String rentalDate;
    private int rentalDays;

    // Constructor
    public Rental(String customerName, String licenseNumber, String vin, String rentalDate, int rentalDays) {
        setCustomerName(customerName);
        setLicenseNumber(licenseNumber);
        setVin(vin);
        setRentalDate(rentalDate);
        setRentalDays(rentalDays);
    }

    // Accessors (Getters)
    public String getCustomerName() {
        return customerName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getVin() {
        return vin;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    // Mutators
    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.isEmpty()) {
            this.customerName = customerName;
        } else {
            System.out.println("Invalid Customer Name.");
        }
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber != null && !licenseNumber.isEmpty()) {
            this.licenseNumber = licenseNumber;
        } else {
            System.out.println("Invalid License Number.");
        }
    }

    public void setVin(String vin) {
        if (vin != null && !vin.isEmpty()) {
            this.vin = vin;
        } else {
            System.out.println("Invalid VIN.");
        }
    }

    public void setRentalDate(String rentalDate) {
        if (rentalDate != null && !rentalDate.isEmpty()) {
            this.rentalDate = rentalDate;
        } else {
            System.out.println("Invalid Rental Date.");
        }
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays > 0) {
            this.rentalDays = rentalDays;
        } else {
            System.out.println("Invalid Number of Rental Days.");
        }
    }

    // Special Purpose Method
    public String toString() {
        return "Customer Name: " + customerName +
               "\nLicense Number: " + licenseNumber +
               "\nCar VIN: " + vin +
               "\nRental Date: " + rentalDate +
               "\nNumber of Days: " + rentalDays;
    }
}