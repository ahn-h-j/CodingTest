import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) throws Exception {
        Queue<Point> queue = new LinkedList<>();

        // 입력 처리
        int M = read(); // 가로(열)
        int N = read(); // 세로(행)

        // board: 토마토 상자
        // dis: 익는 날짜 체크
        int[][] board = new int[N][M];
        int[][] dis = new int[N][M];

        // 토마토 상태 입력
        for (int row = 0; row < N; row++) { // 세로(행)
            for (int col = 0; col < M; col++) { // 가로(열)
                board[row][col] = read();
                if (board[row][col] == 1) { // 익은 토마토 발견
                    queue.offer(new Point(row, col));
                    dis[row][col] = 0;
                }
            }
        }

        // BFS 수행
        BFS(queue, board, dis, N, M);

        // 결과 계산
        int answer = -10;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (board[row][col] == 0) { // 익지 않은 토마토가 있다면
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dis[row][col]); // 최대 날짜 계산
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

                // 범위 확인 및 익지 않은 토마토 처리
                if (neighborX >= 0 && neighborX < N && neighborY >= 0 && neighborY < M && board[neighborX][neighborY] == 0) {
                    board[neighborX][neighborY] = 1; // 익은 상태로 변경
                    queue.offer(new Point(neighborX, neighborY));
                    dis[neighborX][neighborY] = dis[point.x][point.y] + 1; // 날짜 업데이트
                }
            }
        }
    }

    // 빠른 입력 처리 메서드
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m) n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return m ? ~n + 1 : n;
    }
}
