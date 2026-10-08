package uk.ac.westminster.products_api_week1;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Our "database" for now: a list of products held in memory
    private List<Product> products = new ArrayList<>();

    // Constructor: add some starting products
    public ProductController() {
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Mouse", 19.99));
        products.add(new Product(3, "Keyboard", 59.99));
    }

    // GET /products  → all products
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // GET /products/{id}  → one product
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        for (Product p : products) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;   // not found (we'll improve this later)
    }

    // POST /products  → add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
}
