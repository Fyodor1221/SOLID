package org.example;

import org.example.products.*;


public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = Warehouse.get();

        //Magics
        final int QBOOKNUM = 500;
        final int ZENBOOKNUM = 300;
        final int QPHONENUM = 700;
        final int ZENPHONENUM = 1000;

        final int PRICEFILTER = 100_000;
        final String CATFILTER = "Smartphone";

        Qbook qBook = new Qbook();
        Zenbook zenBook = new Zenbook();
        Qphone qPhone = new Qphone();
        Zenphone zenPhone = new Zenphone();

        warehouse.supply(qBook, QBOOKNUM);
        warehouse.supply(zenBook, ZENBOOKNUM);
        warehouse.supply(qPhone, QPHONENUM);
        warehouse.supply(zenPhone, ZENPHONENUM);

        for (Product product : warehouse.getProducts()) {
            System.out.println("На складе есть следующие продукты:");
            System.out.println(product);
            System.out.println();
        }

        for (Product product : warehouse.filterByPrice(PRICEFILTER)) {
            System.out.println("Продукты дороже " + PRICEFILTER + ":");
            System.out.println(product);
            System.out.println();
        }

        for (Product product : warehouse.filterByCat(CATFILTER)) {
            System.out.println("Продукты категории " + CATFILTER + ":");
            System.out.println(product);
            System.out.println();
        }

        Order order = new Order();
        order.add(qBook, 50_000);
        order.add(qBook, 50);
        order.remove(qBook, 49);
        order.changeStatus(OrderStatus.ASSEMBLING);
        order.changeStatus(OrderStatus.DELIVERING);
        order.changeStatus(OrderStatus.RECEIVED);
    }
}