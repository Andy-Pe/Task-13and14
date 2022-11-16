package ru.netology;

public class ProductRepository {
    private Product[] goods = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[tmp.length - 1] = product;
        goods = tmp;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[goods.length - 1];
        int copyToIndex = 0;
        for (Product product : goods) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        goods = tmp;
    }

    public Product[] getProduct() {
        return goods;
    }
}
