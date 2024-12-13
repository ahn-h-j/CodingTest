import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Point> queue = new LinkedList<>();

        // N: 세로(행)
        // M: 가로(열)
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        // board: 토마토 상자
        // dis: 익는 날짜 체크
        int[][] board = new int[N][M];
        int[][] dis = new int[N][M];

        // 토마토 상태 입력
        for (int row = 0; row < N; row++) { // 행
            for (int col = 0; col < M; col++) { // 열
                board[row][col] = scanner.nextInt();
                if (board[row][col] == 1) {
                    queue.offer(new Point(row, col));
                    dis[row][col] = 0;
                }
            }
        }
        BFS(queue, board, dis, N, M);
        int answer = -10;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (board[row][col] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dis[row][col]);
            }
        }
        System.out.println(answer);
    }

    public static void BFS(Queue<Point> queue, int[][] board, int[][] dis, int N, int M) {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int neighborX = point.x + dx[i];
                int neighborY = point.y + dy[i];
                if (neighborX >= 0 && neighborX < N && neighborY >= 0 && neighborY < M && board[neighborX][neighborY] == 0) {
                    board[neighborX][neighborY] = 1;
                    queue.offer(new Point(neighborX, neighborY));
                    dis[neighborX][neighborY] = dis[point.x][point.y] + 1;
                }
            }
        }
    }
}
