package uk.ac.westminster.products_api_week1.dto;

//"A PhysicalProduct IS-A Product because it extends Product Class"
// "A Customer IS not A Product because it doesn't extend Product Class"

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountRate;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Price:" + getPrice()
                + " | Weight (Kg):" + getWeightKg() + " | Product Dimensions:" + getDimensions();
    }

    @Override
    public void applyDiscount(double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0.0 and 1.0");
        }
        discountRate = Math.min(rate, 0.2);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * (1 - discountRate);
    }
}
