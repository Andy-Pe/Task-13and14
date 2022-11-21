package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(1, "Green Mile", "Dr. Dre", 400);
    Product book2 = new Book(74, "John's Adventures", "Stevenson", 800);
    Product book3 = new Book(48, "Maverick", "KarMicael", 600);

    @BeforeEach
    public void setup() {
        manager.matches(book1, "Dr. Dre");
        manager.matches(book2, "Stevenson");
        manager.matches(book3, "KarMicael");

    }

    @Test
    public void shouldSearchByAuthor() {

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Dr. Dre");

        Assertions.assertArrayEquals(expected, actual);
    }



}