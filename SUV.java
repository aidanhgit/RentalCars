/**
 * Superclass representing a rental SUV
 */
public class SUV extends Car {
    private double gasGuzzlerFee;
    
    /**
     * Constructs an SUV object with the information given
     * 
     * @param VIN Vehicle Identification Number for the SUV, cannot be blank
     * @param make Manufacturer of the SUV, cannot be blank
     * @param model Model of the SUV, cannot be blank
     * @param MPG Gas mileage of the SUV, must be greater than 0.0
     * @param price Price per day in USD for renting the SUV, must be greater than 0.0
     * @param gasGuzzlerFee Additional fee for large vehicle, used for percentage calculation (Use 1.05 for a 5% fee)
     * @throws IllegalArgumentException if any parameter does not meet validation criteria
     */
    public SUV(String VIN, String make, String model, double MPG, double price, double gasGuzzlerFee) {
        super(VIN, make, model, MPG, price);
        if (gasGuzzlerFee <= 0.0) {
            throw new IllegalArgumentException("Premium fee must be greater than 0.0");
        }
        this.gasGuzzlerFee = gasGuzzlerFee;
    }

    @Override
    public double getTotalPrice(int days) {
        return super.getTotalPrice(days) * gasGuzzlerFee;
    }

    /**
     * Returns a formatted string representation of the SUV's details
     * 
     * @return String with VIN, make, model, MPG, price, and gas guzzler fee.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGas Guzzler Multiplier: " + gasGuzzlerFee;
    }
}