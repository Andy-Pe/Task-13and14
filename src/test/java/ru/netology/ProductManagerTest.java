package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product good1 = new Product(5, "Green Mile", 200);
    Product good2 = new Product(74, "Iphone5", 1200);
    Product good3 = new Product(87, "John's Adventures", 300);
    Product good4 = new Product(16, "Xiaomi", 800);
    Product good5 = new Product(25, "Nokia", 400);
    Product good6 = new Product(41, "Iphone14", 1200);
    Product good7 = new Product(4, "Iphone11", 1200);
    Product good8 = new Product(7, "John's secrets", 1200);


    @BeforeEach
    public void setup() {
        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);
        manager.add(good5);
        manager.add(good6);
        manager.add(good7);
        manager.add(good8);
    }

    @Test
    public void shouldReverseAllGoods() {

        Product[] expected = {good8, good7, good6, good5, good4, good3, good2, good1};
        Product[] actual = manager.getGoods();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextWithIphone() {

        Product[] expected = {good2, good6, good7};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextWithJohn() {

        Product[] expected = {good3, good8};
        Product[] actual = manager.searchBy("John");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingCoincidence() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Doctor Strength");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlyOneCoincidence() {

        Product[] expected = {good1};
        Product[] actual = manager.searchBy("Green Mile");

        Assertions.assertArrayEquals(expected, actual);
    }
}