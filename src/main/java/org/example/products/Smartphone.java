package org.example.products;

public abstract class Smartphone implements Product {
    protected String name;
    protected static final int PRICEMIN = 10_000;
    protected static final int PRICEMAX = 150_000;
    protected int price;
    protected static final String category = "Smartphone";
    protected int megapixels;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public int getMegapixels() {
        return megapixels;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
