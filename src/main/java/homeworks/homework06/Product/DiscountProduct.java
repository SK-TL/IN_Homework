package main.java.homeworks.homework06.Product;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product{
    private Integer discount = 0;
    private final LocalDate discountDate = LocalDate.of(2025, 06,01);

    public DiscountProduct(String nameProduct, Integer priceProduct, Integer discount) {
        super(nameProduct, priceProduct);

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
        this.discount = discount;
    }

    public double getDiscountedPrice() { // Добавлен метод для вычисления цены со скидкой
        return getPriceProduct() - (getPriceProduct() * ((double) discount/100));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(discount, that.discount) && Objects.equals(discountDate, that.discountDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountDate);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "discount=" + discount +
                ", discountDate=" + discountDate +
                '}';
    }
}
