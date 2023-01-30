package com.asml.rockfield;

/**
 * ASML Assigment for Java Developer role.
 */
public class Assigment {

    /**
     * Traverse the array in a snail pattern and return the traversed path.
     *
     * Given a 2D array
     * {{1,2,3,4},
     * {5,6,7,8},
     * {9,10,11,12},
     * {13,14,15,16}}
     *
     * Print: 1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11, 10
     *
     * @param matrix given MxN matrix
     * @return a String with the traversed pattern
     */
    public String traverse(int[][] matrix) {
        validate(matrix);
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        StringBuilder result = new StringBuilder();
        while ((top < bottom) && (left < right)) {
            moveRight(left, right, result, matrix[top]);
            top++;
            moveDown(top, bottom, result, matrix, right);
            right--;
            moveLeft(left, right, result, matrix[bottom]);
            bottom--;
            moveUp(top, bottom, result, matrix, left);
            left++;
        }
        removeLastComma(result);
        return result.toString();
    }

    private void removeLastComma(StringBuilder result) {
        result.deleteCharAt(result.length() - 1);
    }

    private void moveUp(int top, int bottom, StringBuilder result, int[][] matrix, int column) {
        if (top <= bottom) {
            for (int row = bottom; row >= top; row--) {
                result.append(matrix[row][column]).append(',');
            }
        }
    }

    private void moveLeft(int left, int right, StringBuilder result, int[] row) {
        if (left <= right) {
            for (int i = right; i >= left; i--) {
                result.append(row[i]).append(',');
            }
        }
    }

    private void moveDown(int top, int bottom, StringBuilder result, int[][] matrix, int column) {
        if (top <= bottom) {
            for (int row = top; row <= bottom; row++) {
                result.append(matrix[row][column]).append(',');
            }
        }
    }

    private static void moveRight(int left, int right, StringBuilder result, int[] row) {
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                result.append(row[i]).append(',');
            }
        }
    }

    private void validate(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix is null");
        }
        int rowLength = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null) {
                throw new IllegalArgumentException("Row " + row + " is null");
            }
            if (rowLength == 0) {
                rowLength = matrix[row].length;
            }
            if (rowLength != matrix[row].length) {
                throw new IllegalArgumentException("All rows should be the same size");
            }
        }
    }
}
