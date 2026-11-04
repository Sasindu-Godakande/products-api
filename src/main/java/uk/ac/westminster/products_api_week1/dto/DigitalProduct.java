package uk.ac.westminster.products_api_week1.dto;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSizeMb;
    private double discountRate;

    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMb) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMb = fileSizeMb;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMb() {
        return fileSizeMb;
    }

    @Override
    public String getSummary() {
        return "Digital: " + getName() + " | Price:" + getPrice()
                + " | Download:" + getDownloadUrl() + " | File Size:" + getFileSizeMb();
    }

    @Override
    public void applyDiscount(double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0.0 and 1.0");
        }
        discountRate = rate;
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * (1 - discountRate);
    }
}
