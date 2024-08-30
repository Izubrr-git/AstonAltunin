package lesson8;

import lesson8.exceprions.MyArrayDataException;
import lesson8.exceprions.MyArraySizeException;

import static lesson8.MatrixUtils.*;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("Задание 1: ");
        String[][] matrix = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        try {
            matrix = transposeMatrix(matrix);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера матрицы: " + e.getMessage());
        }
        printMatrix(matrix);

        //Задание 2, 3
        System.out.println("Задание 2, 3: ");
        try {
            int sum = 0;
            sum = sumMatrix(matrix);
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера матрицы: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных в матрице: " + e.getMessage());
        }
    }


}
