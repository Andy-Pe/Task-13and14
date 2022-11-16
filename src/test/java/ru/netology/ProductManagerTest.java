package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product good1 = new Product(5, "Green Mile", 200);
    Product good2 = new Product(74, "Iphone", 1200);
    Product good3 = new Product(87, "John's Adventures", 300);
    Product good4 = new Product(16, "Xiaomi", 800);
    Product good5 = new Product(25, "Nokia", 400);

    @BeforeEach
    public void setup() {
        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);
        manager.add(good5);
    }

    @Test
    public void shouldReverseAllGoods() {

        Product[] expected = {good5, good4, good3, good2, good1};
        Product[] actual = manager.getGoods();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldSearchByText() {

        Product[] expected = {good1, good2, good3, good4, good5};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }
}