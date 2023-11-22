package edu.hillel.homework24_springcore;

import edu.hillel.homework24_springcore.model.Product;
import edu.hillel.homework24_springcore.service.Cart;
import edu.hillel.homework24_springcore.service.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Homework24SpringCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Homework24SpringCoreApplication.class, args);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        Cart cart = applicationContext.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show products for sale.");
            System.out.println("2. Add product to cart.");
            System.out.println("3. Delete  product from cart.");
            System.out.println("4. Show cart contents.");
            System.out.println("5. Exit.");


            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.println("products for sale:");
                    System.out.println(productRepository.getAllProducts());
                    break;
                case 2:
                    System.out.println("Enter product id to add product:");
                    int productId = scanner.nextInt();
                    Product productToAdd = productRepository.getProduct(productId);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Incorrect id.");
                    }
                    break;
                case 3:
                    System.out.println("Enter product id to delete product:");
                    int productToRemoveId = scanner.nextInt();
                    Product productToRemove = productRepository.getProduct(productToRemoveId);
                    if (productToRemove != null) {
                        cart.removeProduct(productToRemove.getId());
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.println("Cart contents:");
                    System.out.println(cart.getCartItems());
                    break;
                case 5:
                    System.out.println("Exit.");
                    System.exit(0);

                default:
                    System.out.println("Incorrect choice. Try again.");
            }
        }

    }

}
