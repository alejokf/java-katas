package clockwisespiral;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SpiralTest {

    private Spiral spiral = new Spiral();

    @Test
    public void testSpiralNegative() {
        int[][] expectedSpiral = new int[0][0];
        int[][] actualSpiral = spiral.createSpiral(-1);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

    @Test
    public void testSpiral1() {
        int[][] expectedSpiral = new int[][]{{1}};
        int[][] actualSpiral = spiral.createSpiral(1);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

    @Test
    public void testSpiral2() {
        int[][] expectedSpiral = new int[][]{{1, 2}, {4, 3}};
        int[][] actualSpiral = spiral.createSpiral(2);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

    @Test
    public void testSpiral3() {
        int[][] expectedSpiral = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] actualSpiral = spiral.createSpiral(3);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

    @Test
    public void testSpiral4() {
        int[][] expectedSpiral = new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] actualSpiral = spiral.createSpiral(4);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

    @Test
    public void testSpiral5() {
        int[][] expectedSpiral = new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};
        int[][] actualSpiral = spiral.createSpiral(5);
        assertArrayEquals(expectedSpiral, actualSpiral);
    }

}