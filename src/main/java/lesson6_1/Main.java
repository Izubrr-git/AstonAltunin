package lesson6_1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        System.out.println("Задача 1: ");
        Product product = new Product(
                "Смартфон XPhone 13",
                LocalDate.of(2023, 9, 15),
                "XPhone Inc",
                "США",
                BigDecimal.valueOf(89990),
                false);
        product.printInfo();
        System.out.println();

        // Задача 2
        System.out.println("Задача 2: ");
        Product[] products = new Product[]{
                new Product("Смартфон XPhone 13", LocalDate.of(2023, 9, 15), "XPhone Inc", "США", BigDecimal.valueOf(89990), false),
                new Product("Ноутбук YBook Air", LocalDate.of(2023, 8, 10), "YTech", "Китай", BigDecimal.valueOf(120000), true),
                new Product("Умные часы ZWatch 5", LocalDate.of(2023, 7, 22), "ZTech", "Япония", BigDecimal.valueOf(35000), false),
                new Product("Наушники ASound Pro", LocalDate.of(2023, 6, 5), "ASound", "Германия", BigDecimal.valueOf(15000), false),
                new Product("Планшет BPad Mini", LocalDate.of(2023, 5, 12), "BPad Corp", "Южная Корея", BigDecimal.valueOf(45000), true)
        };
        products[4].printInfo();
        System.out.println();

        // Задача 3
        System.out.println("Задача 3: ");
        // Создаем каталог товаров
        ProductCatalog electronicsCatalog = new ProductCatalog();

        // Добавляем товары в каталог
        electronicsCatalog.addProduct("Смартфон XPhone 13", BigDecimal.valueOf(89990));
        electronicsCatalog.addProduct("Ноутбук YBook Air", BigDecimal.valueOf(120000));
        electronicsCatalog.addProduct("Умные часы ZWatch 5", BigDecimal.valueOf(35000));
        electronicsCatalog.addProduct("Наушники ASound Pro", BigDecimal.valueOf(15000));

        // Получаем список названий товаров
        List<String> productNames = electronicsCatalog.getProductNames();
        System.out.println("Товары в каталоге электроники:");
        for (String name : productNames) {
            System.out.println("- " + name);
        }

        // Получаем цены товаров
        System.out.println("\nЦены на товары:");
        for (String name : productNames) {
            BigDecimal price = electronicsCatalog.getProductPrice(name);
            System.out.println(name + ": " + price + " руб.");
        }
    }
}