package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product good1 = new Product(5, "Green Mile", 200);
    Product good2 = new Product(74, "Iphone", 1200);
    Product good3 = new Product(87, "John", 300);
    Product good4 = new Product(16, "Xiaomi", 800);
    Product good5 = new Product(25, "Nokia", 400);

    @Test
    public void shouldSaveNewProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(good1);
        repo.save(good2);
        repo.save(good3);
        repo.save(good4);
        repo.save(good5);

        Product[] expected = {good1, good2, good3, good4, good5};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(good1);
        repo.save(good2);
        repo.save(good3);
        repo.save(good4);
        repo.save(good5);
        repo.removeById(good3.getId());

        Product[] expected = {good1, good2, good4, good5};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonExistingElement() {
        ProductRepository repo = new ProductRepository();

        repo.save(good1);
        repo.save(good2);
        repo.save(good3);
        repo.save(good4);
        repo.save(good5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(286);
        });
    }

//    @Test
//    public void shouldAddAlreadyExistElement() {
//        ProductRepository repo = new ProductRepository();
//
//        Assertions.assertThrows(AlreadyExistsException.class, () -> {
//            repo.save(good2);
//        });
//    }
}