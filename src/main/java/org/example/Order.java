package org.example;

import org.example.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products = new HashMap<>();
    private OrderStatus status;
    private Warehouse warehouse = Warehouse.get();

    public Order() {
        this.status = OrderStatus.INITIALIZING;
        logStatus();
    }

    public OrderStatus getStatus() {
        return status;
    }

    private void logStatus() {
        System.out.println(this.status.getExplanation());
    }

    private void logMessage(String message) {
        System.out.println(message);
    }

    public void add(Product product, int amount) {
        if (this.warehouse.pickUp(product, amount)) {
            products.put(product, amount);
            logMessage("К заказу добавлен " + product.getName() + " в количестве " + amount + " штук");
        }
    }

    public void remove(Product product, int amount) {
        if (this.products.get(product) > amount) {
            this.warehouse.supply(product, amount);
            this.products.put(product, this.products.get(product) - amount);
            logMessage("Из заказа удален " + product.getName() + " в количестве " + amount + " штук");
        } else {
            this.warehouse.supply(product, this.products.get(product));
            this.products.remove(product);
            logMessage("Из заказа удалены все " + product.getName());
        }
    }

    //DRY
    public void changeStatus(OrderStatus newStatus) {
        if (newStatus.getNumber() - this.status.getNumber() == 1) {
            this.status = newStatus;
            logStatus();
        } else {
            logMessage("Ошибка! Текущий статус:");
            logStatus();
        }
    }

//    public void assemble() {
//        if (this.status.equals(OrderStatus.INITIALIZING)) {
//            this.status = OrderStatus.ASSEMBLING;
//            logStatus();
//        } else {
//            logMessage("Ошибка! Текущий статус:");
//            logStatus();
//        }
//    }
//
//    public void deliver() {
//        if (this.status.equals(OrderStatus.ASSEMBLING)) {
//            this.status = OrderStatus.DELIVERING;
//            logStatus();
//        } else {
//            logMessage("Ошибка! Текущий статус:");
//            logStatus();
//        }
//    }
//
//    public void give() {
//        if (this.status.equals(OrderStatus.DELIVERING)) {
//            this.status = OrderStatus.RECEIVED;
//            logStatus();
//        } else {
//            logMessage("Ошибка! Текущий статус:");
//            logStatus();
//        }
//    }
}
