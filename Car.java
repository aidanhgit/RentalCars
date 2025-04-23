/**
 * Superclass representing a rental car
 */
public abstract class Car {
    private String VIN;
    private String make;
    private String model;
    private double MPG;
    private double price;
    public static int numCar = 0;

    /**
     * Constructs a Car object with the information given
     * 
     * @param VIN Vehicle Identification Number for the Car, cannot be blank
     * @param make Manufacturer of the Car, cannot be blank
     * @param model Model of the Car, cannot be blank
     * @param MPG Gas mileage of the Car, must be greater than 0.0
     * @param price Price per day in USD for renting the Car, must be greater than 0.0
     * @throws IllegalArgumentException if any parameter does not meet validation criteria
     */
    public Car(String VIN, String make, String model, double MPG, double price) {
        if (VIN == null || VIN.equals("")) {
            throw new IllegalArgumentException("VIN must be provided.");
        }
        if (make == null || make.equals("")) {
            throw new IllegalArgumentException("Vehicle make must be provided.");
        }
        if (model == null || model.equals("")) {
            throw new IllegalArgumentException("Vehicle model must be provided.");
        }
        if (MPG <= 0.0) {
            throw new IllegalArgumentException("MPG must be greater than 0.0");
        }
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price must be more than 0.0");
        }
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.MPG = MPG;
        this.price = price;
    }

    public String getVin() {
        return this.VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getMPG() {
        return MPG;
    }

    public double getPrice() {
        return price;
    }

    public static int getNumCar() {
        return numCar;
    }

    public void setVIN(String VIN) {
        if (VIN == null || VIN.equals("")) {
            throw new IllegalArgumentException("VIN must be provided.");
        }
        this.VIN = VIN;
    }

    public void setMake(String make) {
        if (make == null || make.equals("")) {
            throw new IllegalArgumentException("Vehicle make must be provided.");
        }
        this.make = make;
    }

    public void setModel(String model) {
        if (model == null || model.equals("")) {
            throw new IllegalArgumentException("Vehicle model must be provided.");
        }
        this.model = model;
    }

    public void setMPG(double MPG) {
        if (MPG <= 0.0) {
            throw new IllegalArgumentException("MPG must be greater than 0.0");
        }
        this.MPG = MPG;
    }

    public void setPrice(double price) {
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price must be more than 0.0");
        }
        this.price = price;
    }

    public double getTotalPrice(int days) {
        double total = days * this.price;
        return total;
    }

    public static void updateNumCar() {
        numCar--;
    }

    /**
     * Returns a formatted string representation of the Car's details
     * 
     * @return String with VIN, make, model, MPG, and price per day.
     */
    @Override
    public String toString() {
        return "VIN: " + VIN
        + "\nMake and Model: " + make + " " + model
        + "\nMileage: " + MPG + " mpg" 
        + "\nRental price: $" + price + " per day";
    }

    
}