package edu.hillel.homework24_springcore.service;

import edu.hillel.homework24_springcore.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class Cart {
    private final List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getCartItems() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {
        products.remove(id);
    }
}
