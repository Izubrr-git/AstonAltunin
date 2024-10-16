package lesson8;

import lesson8.exceptions.MyArrayDataException;
import lesson8.exceptions.MyArraySizeException;

import static lesson8.MatrixUtils.printMatrix;
import static lesson8.MatrixUtils.sumMatrix;

public class Main {
    public static void main(String[] args) {
        String[][] matrix = createMatrix();
        try {
            printMatrix(matrix);
            int sum = sumMatrix(matrix);
            System.out.println("Matrix sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Matrix error: " + e.getMessage());
        }
    }

    private static String[][] createMatrix() {
        return new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
    }
}