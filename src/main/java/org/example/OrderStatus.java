package org.example;

public enum OrderStatus {
    INITIALIZING ("Новый заказ формируется", 0),
    ASSEMBLING ("Сборка заказа на складе", 1),
    DELIVERING ("Заказ в пути", 2),
    RECEIVED ("Заказ получен", 3);

    private String explanation;
    private int number;

    OrderStatus(String explanation, int number) {
        this.explanation = explanation;
        this.number = number;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getNumber() {
        return number;
    }
}
