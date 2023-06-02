package org.example.products;

public class Zenbook extends Laptop {
    private final String name = "Zenbook";
    private final int price = (int)(PRICEMIN + Math.random() * ((PRICEMAX - PRICEMIN) + 1));
    private final int buttons = 120;
}
