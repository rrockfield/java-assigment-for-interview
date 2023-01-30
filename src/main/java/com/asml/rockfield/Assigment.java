package com.asml.rockfield;

/**
 * ASML Assigment for Java Developer role.
 */
public class Assigment {

    private enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }

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
        if (matrix.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        // Set boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // Set state machine with latest movement
        Direction lastDirection = Direction.UP;
        while (boundariesAreValid(top, bottom, left, right)) {
            // select next movement based on last direction
            switch (lastDirection) {
                default:
                case UP:
                    lastDirection = moveRight(left, right, result, matrix[top]);
                    // move top one row down
                    top++;
                    break;
                case RIGHT:
                    lastDirection = moveDown(top, bottom, result, matrix, right);
                    // move right boundary one column left
                    right--;
                    break;
                case DOWN:
                    lastDirection = moveLeft(left, right, result, matrix[bottom]);
                    // move bottom one row up
                    bottom--;
                    break;
                case LEFT:
                    lastDirection = moveUp(top, bottom, result, matrix, left);
                    // move left boundary one column right
                    left++;
                    break;
            }
        }
        removeLastComma(result);
        return result.toString();
    }

    private static boolean boundariesAreValid(int top, int bottom, int left, int right) {
        return (top <= bottom) && (left <= right);
    }

    private void removeLastComma(StringBuilder result) {
        if (result.length() > 0 && result.charAt(result.length() - 1) == ',') {
            result.deleteCharAt(result.length() - 1);
        }
    }

    private Direction moveUp(int top, int bottom, StringBuilder result, int[][] matrix, int column) {
        for (int row = bottom; row >= top; row--) {
            result.append(matrix[row][column]).append(',');
        }
        return Direction.UP;
    }

    private Direction moveLeft(int left, int right, StringBuilder result, int[] row) {
        for (int i = right; i >= left; i--) {
            result.append(row[i]).append(',');
        }
        return Direction.LEFT;
    }

    private Direction moveDown(int top, int bottom, StringBuilder result, int[][] matrix, int column) {
        for (int row = top; row <= bottom; row++) {
            result.append(matrix[row][column]).append(',');
        }
        return Direction.DOWN;
    }

    private static Direction moveRight(int left, int right, StringBuilder result, int[] row) {
        for (int i = left; i <= right; i++) {
            result.append(row[i]).append(',');
        }
        return Direction.RIGHT;
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
