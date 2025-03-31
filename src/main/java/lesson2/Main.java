package lesson2;
import java.util.Arrays;

import static lesson2.Exercises.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание №1:");
        printThreeWords();

        System.out.println("\nЗадание №2:");
        checkSumSign();

        System.out.println("\nЗадание №3:");
        printColor();

        System.out.println("\nЗадание №4:");
        compareNumbers();

        System.out.println("\nЗадание №5:");
        System.out.println(isSumInRange(5,10));

        System.out.println("\nЗадание №6:");
        printNegativeStatus(10);

        System.out.println("\nЗадание №7:");
        System.out.println(isNegative(-10));

        System.out.println("\nЗадание №8:");
        printMultipleString(3, "Home");

        System.out.println("\nЗадание №9:");
        System.out.println(isLeapYear(2134));

        System.out.println("\nЗадание №10:");
        System.out.println(Arrays.toString(arrayRevers0and1()));

        System.out.println("\nЗадание №11:");
        System.out.println(Arrays.toString(arrayFill1to100()));

        System.out.println("\nЗадание №12:");
        System.out.println(Arrays.toString(arrayChangeByCondition()));

        System.out.println("\nЗадание №13:");
        System.out.println(Arrays.deepToString(matrixDiagonal()));

        System.out.println("\nЗадание №14:");
        System.out.println(Arrays.toString(fillArray(5,0)));
    }
}
