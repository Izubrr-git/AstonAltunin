package lesson7;

import lesson7.animals.AbstractAnimal;
import lesson7.animals.Bowl;
import lesson7.animals.Cat;
import lesson7.animals.Dog;
import lesson7.figures.Circle;
import lesson7.figures.Rectangle;
import lesson7.figures.Triangle;
import lesson7.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: ");
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");

        dog.run(150);
        dog.swim(5);
        cat1.run(180);
        cat1.swim(1);

        System.out.println("\nВсего животных: " + AbstractAnimal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount() + "\n");

        Bowl bowl = new Bowl(20);

        Cat[] cats = {cat1, cat2};
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println("\nСостояние сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSaturated());
        }

        bowl.addFood(10);

        for (Cat cat : cats) {
            if (!cat.isSaturated()) {
                cat.eat(bowl, 5);
            }
        }
        System.out.println("\nФинальное состояние сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSaturated());
        }

        System.out.println("\nЗадание 2: ");
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle(5, "Красный", "Черный"));
        figures.add(new Rectangle(4, 6, "Синий", "Белый"));
        figures.add(new Triangle(3, 4, 5, "Зеленый", "Желтый"));

        for (Figure figure : figures) {
            figure.printInfo();
        }
    }
}
