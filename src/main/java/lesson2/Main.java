package lesson2;
import java.util.Arrays;

import static lesson2.Exercises.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1:");
        printThreeWords();

        System.out.println("Задание №2:");
        checkSumSign();

        System.out.println("Задание №3:");
        printColor();

        System.out.println("Задание №4:");
        compareNumbers();

        System.out.println("Задание №5:");
        System.out.println(isSumInRange(5,10));

        System.out.println("Задание №6:");
        printNegativeStatus(10);

        System.out.println("Задание №7:");
        System.out.println(isNegative(-10));

        System.out.println("Задание №8:");
        printMultipleString(3, "Home");

        System.out.println("Задание №9:");
        System.out.println(isLeapYear(1800));

        System.out.println("Задание №10:");
        System.out.println(Arrays.toString(arrayRevers0and1()));

        System.out.println("Задание №11:");
        System.out.println(Arrays.toString(arrayFill1to100()));

        System.out.println("Задание №12:");
        System.out.println(Arrays.toString(arrayChangeByCondition()));

        System.out.println("Задание №13:");
        System.out.println(Arrays.deepToString(matrixDiagonal()));

        System.out.println("Задание №14:");
        System.out.println(Arrays.toString(fillArray(5,0)));
    }
}
