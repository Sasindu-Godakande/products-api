package uk.ac.westminster.products_api_week1.dto;

//"A PhysicalProduct IS-A Product because it extends Product Class"
// "A Customer IS not A Product because it doesn't extend Product Class"

public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

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
}
