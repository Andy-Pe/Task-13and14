package ru.netology;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone(String manufacturer, int id, String name, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
