package main.java.homeworks.homework07.Product;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product{
    private Integer discount = 0;
    private final LocalDate discountDate = LocalDate.of(2025, 12,01);

    public DiscountProduct(String nameProduct, Integer priceProduct, Integer discount) {
        super(nameProduct, priceProduct);
        this.discount = discount;
    }

    public int getDiscountedPrice() { // Добавлен метод для вычисления цены со скидкой
        return (int) (getPriceProduct() - (getPriceProduct() * ((double) discount/100)));
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "nameProduct='" + getNameProduct() + '\'' +
                ", priceProduct=" + getPriceProduct() +
                ", discountPercentage=" + discount +
                ", discountedPrice=" + getDiscountedPrice() +
                '}';
    }
}