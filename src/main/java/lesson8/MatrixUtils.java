package lesson8;

import lesson8.exceprions.MyArrayDataException;
import lesson8.exceprions.MyArraySizeException;

public class MatrixUtils  {
    // Объявляем переменную для размера массива (по ТЗ)
    private static final int ARRAY_SIZE = 4;

    private static void validateMatrixSize(String[][] matrix) throws MyArraySizeException {
        // Проверка, что матрица 4x4
        if (matrix.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Matrix columns count must by 4");
        }

        if (matrix[0].length != ARRAY_SIZE) {
            throw new MyArraySizeException("Matrix rows count must by 4");
        }
    }

    public static String[][] transposeMatrix(String[][] matrix) throws MyArraySizeException {
        validateMatrixSize(matrix);

        // Определяем размеры исходной матрицы
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Создаем новую матрицу для хранения результата транспонирования
        String[][] transposedMatrix = new String[cols][rows];

        // Перебираем элементы исходной матрицы и заполняем новую
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] values : matrix) {
            for (String value : values) {
                System.out.printf("%4s ", value);
            }
            System.out.println();
        }
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
}
