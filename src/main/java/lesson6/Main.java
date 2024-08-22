package lesson6;

import utility.enums.AttractionType;
import utility.exceptions.InvalidEmailException;
import utility.exceptions.InvalidSalaryException;
import utility.exceptions.TimeRange;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee employee;
        try {
            employee = new Employee("Иван", "Иванов", 25, "Разработчик", BigDecimal.valueOf(50000), "example@example.com");
        } catch (InvalidEmailException | InvalidSalaryException e) {
            throw new RuntimeException(e);
        }

        // Задача 1
        System.out.println("Задача 1: ");
        employee.printInfo();
        System.out.println();

        // Задача 2
        System.out.println("Задача 2: ");
        Employee[] employees;
        try {
            employees = new Employee[]{
                    new Employee("Иван", "Иванов", 25, "Разработчик", BigDecimal.valueOf(50000), "example@example.com"),
                    new Employee("Петр", "Петров", 30, "Менеджер", BigDecimal.valueOf(60000), "petr@example.com"),
                    new Employee("Сергей", "Сергеев", 35, "Директор", BigDecimal.valueOf(70000), "sergey@example.com"),
                    new Employee("Алексей", "Алексеев", 28, "Дизайнер", BigDecimal.valueOf(55000), "aleksey@example.com"),
                    new Employee("Дмитрий", "Дмитриев", 32, "Маркетолог", BigDecimal.valueOf(65000), "dmitriy@example.com")
            };
        } catch (InvalidEmailException | InvalidSalaryException e) {
            throw new RuntimeException(e);
        }
        employees[4].printInfo();
        System.out.println();

        //Задача 3
        System.out.println("Задача 3: ");
        // Создаем экземпляр парка
        Park disneyland = new Park();

        // Добавляем аттракционы
        disneyland.addAttraction("Space Mountain", 50.0);
        disneyland.addAttraction("Pirates of the Caribbean", 40.0);
        disneyland.addAttraction("Haunted Mansion", 45.0);
        disneyland.addAttraction("It's a Small World", 35.0);

        // Получаем список названий аттракционов
        List<String> attractionNames = disneyland.getAttractionNames();
        System.out.println("Аттракционы в Disneyland:");
        for (String name : attractionNames) {
            System.out.println("- " + name);
        }

        // Получаем цены аттракционов
        System.out.println("\nЦены на аттракционы:");
        for (String name : attractionNames) {
            double price = disneyland.getAttractionPrice(name);
            System.out.println(name + ": $" + price);
        }
    }
}

