package org.example.products;

public abstract class Laptop implements Product {
    protected String name;
    protected static final int PRICEMIN = 30_000;
    protected static final int PRICEMAX = 200_000;
    protected int price;
    protected static final String category = "Laptop";
    protected int buttons;

    public void setPrice() {
        this.price = (int)(PRICEMIN + Math.random() * ((PRICEMAX - PRICEMIN) + 1));
    }

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

    public int getButtons() {
        return buttons;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
