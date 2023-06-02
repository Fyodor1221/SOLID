package org.example;

import org.example.products.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Warehouse {
    private Map<Product, Integer> products = new HashMap<>();

    // Singleton constructor
    private static Warehouse instance = null;
    public static Warehouse get() {
        if(instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    //возвращает неизменяемый список ключей
    public Product[] getProducts() {
        return this.products.keySet().toArray(new Product[0]);
    }

    public Integer getAmount(Product product) {
        return this.products.get(product);
    }

    public Warehouse supply(Product product, int amount) {
        this.products.put(product, amount);
        return this;
    }
    
    public boolean pickUp(Product product, int amount) {
        if (this.getAmount(product) == null) {
            System.out.println("Товар отсутствует на складе");
            return false;
        }
        if (this.getAmount(product) < amount) {
            System.out.println("Этого товара не так много на складе");
            return false;
        }
        else {
            this.products.put(product, this.products.get(product) - amount);
        }
        return true;
    }

    public List<Product> filterByPrice(int price) {
        return Arrays.stream(getProducts()).filter(product -> product.
                getPrice() > price).collect(Collectors.toList());
    }

    public List<Product> filterByCat(String category) {
        return Arrays.stream(getProducts()).filter(product -> product.
                getCategory().equals(category)).collect(Collectors.toList());
    }
}
