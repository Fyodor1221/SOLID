package org.example.products;

public class Qphone extends Smartphone {
    private final String name = "Qphone";
    private final int price = (int)(PRICEMIN + Math.random() * ((PRICEMAX - PRICEMIN) + 1));
    private final int megapixels = 100;
}
