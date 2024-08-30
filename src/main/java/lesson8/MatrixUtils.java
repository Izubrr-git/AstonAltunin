package lesson8;

import lesson8.exceptions.MyArrayDataException;
import lesson8.exceptions.MyArraySizeException;

import java.util.Arrays;

public class MatrixUtils {
    // Объявляем переменную для размера массива (по ТЗ)
    private static final int MATRIX_SIZE = 4;

    private static void validateMatrixSize(String[][] matrix) throws MyArraySizeException {
        // Проверка, что матрица ARRAY_SIZE x ARRAY_SIZE
        if (matrix.length != MATRIX_SIZE) {
            throw new MyArraySizeException("Matrix columns count must by " + MATRIX_SIZE);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != MATRIX_SIZE) {
                throw new MyArraySizeException("Matrix columns in " + i + " row must be " + MATRIX_SIZE);
            }
        }
    }

    public static void printMatrix(String[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

    public static int sumMatrix(String[][] matrix) throws MyArrayDataException, MyArraySizeException {
        validateMatrixSize(matrix);

        int sum = 0;

        // Перебор строк матрицы
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    // Преобразуем строку в число
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    // Выбрасываем исключение с указанием ячейки
                    throw new MyArrayDataException("Invalid data in cell: [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }

    //    public static String[][] transposeMatrix(String[][] matrix) throws MyArraySizeException {
//        validateMatrixSize(matrix);
//
//        // Определяем размеры исходной матрицы
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        // Создаем новую матрицу для хранения результата транспонирования
//        String[][] transposedMatrix = new String[cols][rows];
//
//        // Перебираем элементы исходной матрицы и заполняем новую
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                transposedMatrix[j][i] = matrix[i][j];
//            }
//        }
//
//        return transposedMatrix;
//    }
}
