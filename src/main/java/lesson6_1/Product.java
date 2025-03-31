package lesson6_1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private String name = "Товар";
    private LocalDate productionDate = LocalDate.now();
    private String manufacturer = "Производитель";
    private String countryOfOrigin = "Россия";
    private BigDecimal price = BigDecimal.valueOf(1000);
    private boolean reserved = false;

    public Product(String name, LocalDate productionDate, String manufacturer,
                   String countryOfOrigin, BigDecimal price, boolean reserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reserved = reserved;
    }

    public void printInfo() {
        System.out.println("======= Информация о товаре =======");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (reserved ? "Забронирован" : "Не забронирован"));
    }
}