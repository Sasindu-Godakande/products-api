package uk.ac.westminster.products_api_week1.dto;

import java.util.ArrayList;
import java.util.List;

public class BundleProduct extends Product {

    private List<Product> items;

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items;
    }

    public BundleProduct() {
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String getSummary() {

        List<String> names = new ArrayList<>();
        for (Product b : items) {
            names.add(b.getName());
        }
        long count = items.size();
        return "Bundle: " + getName() + " | Price:" + getPrice()
                + " | Number of Items:" + count + " | Items:" + String.join(",", names);
    }
}
