package ru.netology;

public class Book extends Product {

    private String author;

    public Book(int id, String name, String author, int price) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(Product product, String author) {
        if(product.matches(product, author)) {
            return true;
        } else {
            return false;
        }
    }
}
