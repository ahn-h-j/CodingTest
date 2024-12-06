import java.util.ArrayList;

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class Solution {
    public int solution(int m, int n, String[] board) {
        int totalRemoved = 0;
        char[][] matrix = new char[m][n];

        for (int index = 0; index < m; index++) {
            matrix[index] = board[index].toCharArray();
        }

        while (true) {
            ArrayList<Coordinate> matchingCoordinate = new ArrayList<>();
            matching(matchingCoordinate, matrix, m, n);

            if (matchingCoordinate.isEmpty()) {
                break;
            }

            totalRemoved += removeBlock(matchingCoordinate, matrix);
            applyGravity(matrix, m, n);
        }

        return totalRemoved;
    }

    public void matching(ArrayList<Coordinate> matchingCoordinate, char[][] matrix, int m, int n) {
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                char pick = matrix[row][col];
                if (pick != ' ' &&
                        matrix[row + 1][col] == pick &&
                        matrix[row][col + 1] == pick &&
                        matrix[row + 1][col + 1] == pick) {
                    matchingCoordinate.add(new Coordinate(row, col));
                    matchingCoordinate.add(new Coordinate(row + 1, col));
                    matchingCoordinate.add(new Coordinate(row, col + 1));
                    matchingCoordinate.add(new Coordinate(row + 1, col + 1));
                }
            }
        }
    }

    public int removeBlock(ArrayList<Coordinate> matchingCoordinate, char[][] matrix) {
        int totalRemoved = 0;
        for (Coordinate coordinate : matchingCoordinate) {
            int x = coordinate.getX();
            int y = coordinate.getY();
            if (matrix[x][y] != ' ') {
                matrix[x][y] = ' ';
                totalRemoved++;
            }
        }
        return totalRemoved;
    }

    public void applyGravity(char[][] matrix, int m, int n) {
        for (int col = 0; col < n; col++) {
            int blankRow = m - 1;
            for (int row = m - 1; row >= 0; row--) {
                if (matrix[row][col] != ' ') {
                    char block = matrix[row][col];
                    matrix[row][col] = ' ';
                    matrix[blankRow][col] = block;
                    blankRow--;
                }
            }
        }
    }
}
