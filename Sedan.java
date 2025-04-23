/**
 * Superclass representing a rental sedan
 */
public class Sedan extends Car {
    private boolean isLuxury;
    
    /**
     * Constructs a Sedan object with the information given
     * 
     * @param VIN Vehicle Identification Number for the Sedan, cannot be blank
     * @param make Manufacturer of the Sedan, cannot be blank
     * @param model Model of the Sedan, cannot be blank
     * @param MPG Gas mileage of the Sedan, must be greater than 0.0
     * @param price Price per day in USD for renting the Sedan, must be greater than 0.0
     * @param isLuxury Boolean for whether the sedan is a luxury car, doubles price if true.
     * @throws IllegalArgumentException if any parameter does not meet validation criteria
     */
    public Sedan(String VIN, String make, String model, double MPG, double price, boolean isLuxury) {
        super(VIN, make, model, MPG, price);
        this.isLuxury = isLuxury;
    }

    @Override
    public double getTotalPrice(int days) {
        double total = super.getTotalPrice(days);
        if (isLuxury) {
            total *= 2;
        }
        return total;
    }

    /**
     * Returns a formatted string representation of the Sedan's details
     * 
     * @return String with VIN, make, model, MPG, price, and luxury car status.
     */
    @Override
    public String toString() {
        String output = super.toString();
        if (isLuxury) {
            output += "\nThis is a luxury vehicle.";
        }
        return output;
    }
}