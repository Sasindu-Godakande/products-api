package uk.ac.westminster.products_api_week1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class Product {

    private Integer id;
    private String name;
    private double price;

    // Constructor
    public Product(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Default constructor - needed by Spring for @RequestBody
    public Product() {
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return new Product(id, "laptop", 5000.00);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product);
        return product;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

}