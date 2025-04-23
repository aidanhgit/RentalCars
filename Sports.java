/**
 * Subclass representing a rental sports car
 */
public class Sports extends Car {
    private double premiumFee;
    
    /**
     * Constructs a Sports car object with the information given
     * 
     * @param VIN Vehicle Identification Number for the Sports car, cannot be blank
     * @param make Manufacturer of the Sports car, cannot be blank
     * @param model Model of the Sports car, cannot be blank
     * @param MPG Gas mileage of the Sports car, must be greater than 0.0
     * @param price Price per day in USD for renting the Sports car, must be greater than 0.0
     * @param premiumFee Additional fee for high-end vehicle, flat dollar amount added to total price calculation
     * @throws IllegalArgumentException if any parameter does not meet validation criteria
     */
    public Sports(String VIN, String make, String model, double MPG, double price, double premiumFee) {
        super(VIN, make, model, MPG, price);
        if (premiumFee <= 0.0) {
            throw new IllegalArgumentException("Premium fee must be greater than 0.0");
        }
        this.premiumFee = premiumFee;
    }

    @Override
    public double getTotalPrice(int days) {
        return super.getTotalPrice(days) + premiumFee;
    }

    /**
     * Returns a formatted string representation of the Sports car's details
     * 
     * @return String with VIN, make, model, MPG, price, and premium fee.
     */
    @Override
    public String toString() {
        return super.toString() + "\nPremium Fee: $" + premiumFee;
    }
}