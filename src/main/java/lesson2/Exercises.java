package lesson2;

import java.util.Arrays;

public class Exercises {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5, b = 10;
        if (a + b >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 10;
        if (value <= 0) System.out.println("Красный");
        else if (0 < value && value <= 100) System.out.println("Жёлтый");
        else System.out.println("Зелёный");
    }

    public static String compareNumbers() {
        int a = 5, b = 10;
        if (a >= b) return "a >= b";
        else return "a < b";
    }

    public static boolean isSumInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void printNegativeStatus(int a) {
        if(a >= 0) System.out.println("Число положительное");
        else System.out.println("Число положительное");
    }

    public static boolean isNegative(int a) {
        return a > 0;
    }

    public static void printMultipleString(int repeats, String repeatingWord) {
        for (int i = 0; i <= repeats; i++) System.out.println(repeatingWord);
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 || year % 400 == 0;
    }

    public static int[] exercise10() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    public static int[] exercise11() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] exercise12() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 2;
        }
        return array;
    }

    public static int[][] exercise13() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) { // Итерация по строкам
            for (int j = 0; j < matrix[i].length; j++) { // Итерация по столбцам
                if (i == j || i + j == matrix.length - 1) matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static int[] fillArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}
