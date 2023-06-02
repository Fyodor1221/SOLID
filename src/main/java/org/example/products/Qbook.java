package org.example.products;

public class Qbook extends Laptop {
    private final String name = "Qbook";
    private final int price = (int)(PRICEMIN + Math.random() * ((PRICEMAX - PRICEMIN) + 1));
    private final int buttons = 100;
}
