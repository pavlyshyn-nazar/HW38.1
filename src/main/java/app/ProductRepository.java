package app;

import java.util.ArrayList;
import java.util.List;

class ProductRepository {
private List<Product> products = new ArrayList<>();

public ProductRepository() {
        // Initialize the product list with sample data
        products.add(new Product(1, "Product A", 10.99));
        products.add(new Product(2, "Product B", 19.99));
        // Add more products as needed
        }

public List<Product> getAllProducts() {
        return products;
        }

public Product getProductById(int id) {
        for (Product product : products) {
        if (product.getId() == id) {
        return product;
        }
        }
        return null; // Product not found
        }

public void addProduct(Product product) {
        products.add(product);
        }

public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
        }
}