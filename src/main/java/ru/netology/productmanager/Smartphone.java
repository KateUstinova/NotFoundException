package ru.netology.productmanager;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String title) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
