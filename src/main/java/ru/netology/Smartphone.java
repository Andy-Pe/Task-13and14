package ru.netology;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone(String manufacturer, int id, String name, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(Product product, String search) {
        if(product.matches(product, search)) {
            return true;
        } else {
            return false;
        }
    }
}

