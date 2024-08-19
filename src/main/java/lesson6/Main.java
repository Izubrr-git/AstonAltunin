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
        // Создаем парк
        Park disneylandParis = new Park("Disneyland Paris", 1980, "Bd de Parc, 77700 Coupvray, France");

        // Создаем аттракционы
        Map<DayOfWeek, TimeRange> defaultSchedule = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            defaultSchedule.put(day, new TimeRange(LocalTime.of(9, 0), LocalTime.of(22, 0)));
        }

        Park.Attraction bigThunderMountain = disneylandParis.new Attraction(
                "Big Thunder Mountain",
                new Date(),  // текущая дата как дата последнего обслуживания
                8,  // минимальный возраст
                1000,  // максимальное количество поездок до обслуживания
                1992,  // год постройки
                15,  // цена в USD
                new HashMap<>(defaultSchedule),
                AttractionType.ROLLER_COASTER,
                80,  // длина в метрах
                30   // ширина в метрах
        );

        Park.Attraction itsASmallWorld = disneylandParis.new Attraction(
                "It's a Small World",
                new Date(),
                0,  // нет ограничений по возрасту
                2000,
                1992,
                10,
                new HashMap<>(defaultSchedule),
                AttractionType.WATER_RIDE,
                100,
                40
        );

        // Добавляем аттракционы в парк
        disneylandParis.addAttraction(bigThunderMountain);
        disneylandParis.addAttraction(itsASmallWorld);

        // Выводим информацию об аттракционе It's a Small World
        List<Park.Attraction> attractions = disneylandParis.getAttractions();
        for (Park.Attraction attraction : attractions) {
            if (attraction.getName().equals("It's a Small World")) {
                attraction.printInfo("basic");
            }
        }

        // Проверяем, открыт ли аттракцион в определенное время
        LocalTime currentTime = LocalTime.of(14, 30);
        DayOfWeek currentDay = DayOfWeek.MONDAY;
        System.out.println("Big Thunder Mountain открыт в " + currentTime + " в " + currentDay + ": "
                + bigThunderMountain.isOpenAt(currentDay, currentTime));
    }
}

