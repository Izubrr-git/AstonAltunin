package lesson7.figures;

public interface Figure {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    // Дефолтный метод для вывода информации о фигуре
    default void printInfo() {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
