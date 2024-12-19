import java.util.Arrays;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        int[][] status = new int[n][n]; // 압축 여부 저장
        int zeroCount = 0;
        int oneCount = 0;

        for (int matrixSize = 2; matrixSize <= n; matrixSize *= 2) {
            for (int x = 0; x < n; x += matrixSize) {
                for (int y = 0; y < n; y += matrixSize) {
                    compress(arr, status, x, y, matrixSize);
                }
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] == 0) zeroCount++;
                if (arr[x][y] == 1) oneCount++;
            }
        }
        answer[0] = zeroCount;
        answer[1] = oneCount;
        return answer;
    }

    private void compress(int[][] arr, int[][] status, int initialX, int initialY, int size) {
        int firstValue = -1;
        boolean isCompress = true;

        for (int x = initialX; x < initialX + size; x++) {
            for (int y = initialY; y < initialY + size; y++) {
                if (arr[x][y] == -1) continue;
                if (firstValue == -1) {//-1이 아니면
                    firstValue = arr[x][y];
                } else if (arr[x][y] != firstValue) {
                    isCompress = false;
                    break;
                }
            }
            if (!isCompress) break;
        }

        if (isCompress) {
            status[initialX][initialY] = 1;
            for (int x = initialX; x < initialX + size; x++) {
                for (int y = initialY; y < initialY + size; y++) {
                    if (x != initialX || y != initialY) {
                        arr[x][y] = -1;
                    }
                }
            }
        } else {
            status[initialX][initialY] = 0;
        }
    }

}
