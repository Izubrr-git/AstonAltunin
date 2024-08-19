package lesson6;

import utility.exceptions.InvalidEmailException;
import utility.exceptions.InvalidSalaryException;
import utility.exceptions.Validator;

import java.math.BigDecimal;

public class Employee {
    String firstName = "Иван";
    String lastName = "Иванов";
    int age = 25;
    String position = "Разработчик";
    BigDecimal salary = BigDecimal.valueOf(50000);
    String email = "example@example.com";

    public Employee(String firstName, String lastName, int age, String position, BigDecimal salary, String email) throws InvalidEmailException, InvalidSalaryException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        if (salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidSalaryException("Зарплата должна быть больше нуля");
        }
        this.salary = salary;
        if (!Validator.isValidEmail(email)) {
            throw new InvalidEmailException("Неправильный почтовый адрес");
        }
        this.email = email;
    }

    public void printInfo() {
        System.out.println("======= Информация о сотруднике =======");
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + position);
        System.out.println("Зарплата: " + salary);
        System.out.println("Электронная почта: " + email);
    }
}

