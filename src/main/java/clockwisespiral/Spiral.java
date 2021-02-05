package clockwisespiral;

import clockwisespiral.Position.Direction;
import org.jetbrains.annotations.NotNull;

public class Spiral {

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int n = 7;
        int digits = String.valueOf(n * n).length();
        String format = "%0" + digits + "d ";
        int[][] matrix = spiral.createSpiral(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(format, matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] createSpiral(int n) {
        if (n < 0) {
            return new int[0][0];
        }

        int[][] spiral = new int[n][n];
        Position currentPosition = Position.of(0, 0, Direction.RIGHT);
        spiral[0][0] = 1;
        for (int i = 2; i <= n * n; i++) {
            currentPosition = findNextPosition(currentPosition, n);
            spiral[currentPosition.row][currentPosition.col] = i;
        }

        return spiral;
    }

    @NotNull
    private Position findNextPosition(Position currentPosition, int spiralSize) {
        Direction direction = findIncreasingDirection(currentPosition, spiralSize);
        switch (direction) {
            case LEFT:
                return Position.of(currentPosition.row, currentPosition.col - 1, direction);
            case RIGHT:
                return Position.of(currentPosition.row, currentPosition.col + 1, direction);
            case UP:
                return Position.of(currentPosition.row - 1, currentPosition.col, direction);
            case DOWN:
                return Position.of(currentPosition.row + 1, currentPosition.col, direction);
            default:
                throw new IllegalStateException("I screwed it up!");
        }
    }

    @NotNull
    private Direction findIncreasingDirection(Position currentPosition, int spiralSize) {
        if (changeDirection(currentPosition, spiralSize)) {
            switch (currentPosition.direction) {
                case LEFT:
                    return Direction.UP;
                case RIGHT:
                    return Direction.DOWN;
                case UP:
                    return Direction.RIGHT;
                case DOWN:
                    return Direction.LEFT;
                default:
                    throw new IllegalStateException("I screwed it up!");
            }
        } else {
            // Keep in the same direction
            return currentPosition.direction;
        }
    }

    private boolean changeDirection(Position currentPosition, int spiralSize) {
        switch (currentPosition.direction) {
            // If we are going left or right, we change direction when we reach the top-right to bottom-left diagonal (/)
            case RIGHT:
            case LEFT:
                return currentPosition.col + currentPosition.row  == spiralSize - 1;
            // If we are going down, we change direction when we reach the top-left to bottom-right diagonal (\)
            case DOWN:
                return currentPosition.col == currentPosition.row;
            // If we are going down, we change direction 1 position before we reach the top-left to bottom-right diagonal (\)
            case UP:
                return currentPosition.col == currentPosition.row - 1;
            default:
                throw new IllegalStateException("I screwed it up!");
        }
    }
}
