package app;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(int id) {
        items.removeIf(product -> product.getId() == id);
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
