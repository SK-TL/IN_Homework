package main.java.homeworks.homework08;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private Integer priceProduct;

    public Product(String nameProduct, Integer priceProduct) {
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (nameProduct.trim().length() < 3) { // Добавлено условие, что название не должно быть короче 3-х символов.
            throw new IllegalArgumentException("Название продукта не может быть короче 3-х символов");
        }
        if (priceProduct <= 0) { //Изменено условие, что стоимость продукта не может быть отрицательной или равно 0.
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной или равна нулю");
        }
        if(isOnlyDigits(nameProduct.trim())){ // Добавлено условие, что название не должно содержать только цифры.
            throw new IllegalArgumentException("Название продукта не должно содержать только цифры");
        }

        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    protected boolean isOnlyDigits(String str) {
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
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
