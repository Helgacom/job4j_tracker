package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i >= index && i < products.length - 1) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
            if (i == products.length - 1) {
                products[i] = null;
            }
        }
        return products;
    }
}
