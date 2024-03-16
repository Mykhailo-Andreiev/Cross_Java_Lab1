package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Task4 {

    public static void execute() {
        String[] stringArray = createArray(String.class, 3);
        fillArray(stringArray, "hi");
        System.out.println("Before resizing: ");
        System.out.println(arrayToString(stringArray));
        stringArray = resizeArray(stringArray, 5, String.class);
        System.out.println("After resizing: ");
        System.out.println(arrayToString(stringArray));

//        System.out.println();
//        System.out.println();
//
//        Predicate[][] arrayListMatrix = createMatrix(Predicate.class, 2, 2);
//        fillMatrix(arrayListMatrix, Objects::nonNull);
//        System.out.println("ArrayList matrix with size [2][2]:");
//        System.out.print(matrixToString(arrayListMatrix));
//        System.out.println(arrayListMatrix[1][1].getClass());
//
//        System.out.println();
//        System.out.println();
//
//        Integer[][] arrayListInteger = createMatrix(Integer.class, 4, 4);
//        fillMatrix(arrayListInteger, 10);
//        System.out.println("ArrayList matrix with size [2][2]:");
//        System.out.print(matrixToString(arrayListInteger));
//        System.out.println(arrayListInteger[1][1].getClass());
    }

    public static <T> void fillArray(T[] array, T value) {
        Arrays.fill(array, value);
    }

    public static <T> void fillMatrix(T[][] matrix, T value) {
        for (T[] row : matrix) {
            Arrays.fill(row, value);
        }
    }

    public static <T> T[] createArray(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, size);
    }

    public static <T> T[][] createMatrix(Class<T> type, int rows, int cols) {
        T[][] matrix = (T[][]) Array.newInstance(type, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = null;
            }
        }
        return matrix;
    }

    public static <T> T[] resizeArray(T[] array, int newSize, Class<T> elementType) {
        T[] newArray = (T[]) Array.newInstance(elementType, newSize);
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }

    public static String arrayToString(Object[] array) {
        return Arrays.toString(array);
    }

    public static String matrixToString(Object[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (Object[] row : matrix) {
            sb.append(Arrays.toString(row));
            sb.append('\n');
        }
        return sb.toString();
    }
}
