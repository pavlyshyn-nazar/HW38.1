package app;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View products");
            System.out.println("2. Add product to cart");
            System.out.println("3. Remove product from cart");
            System.out.println("4. View cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Product> allProducts = productRepository.getAllProducts();
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    Product productToAdd = productRepository.getProductById(productId);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    cart.removeProduct(productIdToRemove);
                    System.out.println("Product removed from cart.");
                    break;
                case 4:
                    List<Product> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("Cart items:");
                        for (Product product : cartItems) {
                            System.out.println(product);
                        }
                        System.out.println("Total price: " + cart.getTotalPrice());
                    }
                    break;
                case 5:
                    System.out.println("Checkout completed.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
