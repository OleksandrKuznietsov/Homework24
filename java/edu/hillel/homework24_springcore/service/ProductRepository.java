package edu.hillel.homework24_springcore.service;

import edu.hillel.homework24_springcore.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    private  Map<Integer, Product> availableProducts;

    @PostConstruct
    public void fillProductsList() {
      availableProducts = new HashMap<>();
      Product apple = new Product(1, "Apple", 5.0);
      Product orange = new Product(2, "Orange", 6.0);
      Product kiwi = new Product(3, "Kiwi", 7.0);
      availableProducts.put(apple.getId(), apple);
      availableProducts.put(orange.getId(), orange);
      availableProducts.put(kiwi.getId(), kiwi);
    }

    public Product getProduct(int id) {
        return availableProducts.get(id);
    }

    public Map<Integer, Product> getAllProducts() {
        return availableProducts;
    }

}
