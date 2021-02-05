package clockwisespiral;

/**
 * This class representa a position in a matrix with a current moving direction
 */
public class Position {

    int row;
    int col;
    Direction direction;

    private Position(int row, int col, Direction direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    public static Position of(int row, int col, Direction direction) {
        return new Position(row, col, direction);
    }

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}
