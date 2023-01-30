package com.asml.rockfield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssigmentTest {

    Assigment assigment = new Assigment();

    @Test
    public void nullMatrixThrowsException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assigment.traverse(null);
        });
        String expectedMessage = "Matrix is null";
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void nullRowThrowsException() {
        int[][] givenArray = {{1,2,3,4}, null, {5,6,7,8}};
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assigment.traverse(givenArray);
        });
        String expectedMessage = "Row 1 is null";
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void rowsWithDifferentLengthThrowException() {
        int[][] givenArray = {{1,2,3,4}, {5,6,7,8}, {9}};
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assigment.traverse(givenArray);
        });
        String expectedMessage = "All rows should be the same size";
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testEmptyArray() {
        int[][] givenArray = {};
        String expectedString = "";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testEmptyRow() {
        int[][] givenArray = {{}};
        String expectedString = "";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testEmptyRows() {
        int[][] givenArray = {{}, {}, {}};
        String expectedString = "";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testSquareMatrix() {
        int[][] givenArray = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        String expectedString = "1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void testShortWideMatrix() {
        int[][] givenArray = {{1,2,3,4,5,6,7,8}, {9,10,11,12,13,14,15,16}};
        String expectedString = "1,2,3,4,5,6,7,8,16,15,14,13,12,11,10,9";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testTallThinMatrix() {
        int[][] givenArray = {{1},{2},{3},{4},{5},{6},{7},{8}};
        String expectedString = "1,2,3,4,5,6,7,8";
        String actualString = assigment.traverse(givenArray);
        Assertions.assertEquals(expectedString, actualString);
    }
}
