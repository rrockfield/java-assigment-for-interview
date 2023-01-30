package com.asml.rockfield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssigmentTest {

    Assigment assigment = new Assigment();

    @Test
    public void testHappyPath() {
        int[][] givenArray = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        String expected = "1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10";
        String result = assigment.traverse(givenArray);
        Assertions.assertEquals(result, expected);
    }
}
