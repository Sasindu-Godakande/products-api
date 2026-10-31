package uk.ac.westminster.products_api_week1.dto;

public interface Discountable {
    void applyDiscount(double rate);
    double getDiscountedPrice();
}
