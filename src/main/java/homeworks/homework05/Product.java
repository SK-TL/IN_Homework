package main.java.homeworks.homework05;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private Integer priceProduct;

    public Product(String nameProduct, Integer priceProduct) {
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (priceProduct < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct) && Objects.equals(priceProduct, product.priceProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, priceProduct);
    }
}
