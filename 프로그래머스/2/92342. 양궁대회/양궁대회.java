import java.util.*;

public class Solution {
    static int maxDifference = 0;
    static int[] bestCombination;

    public static int[] solution(int n, int[] info) {
        bestCombination = new int[11]; // 결과 배열 초기화
        int[] lion = new int[11];     // 라이언의 점수 상태를 저장할 배열

        dfs(n, 0, lion, info);        // DFS를 사용하여 모든 경우의 수 탐색

        if (maxDifference == 0) return new int[]{-1}; // 라이언이 이길 수 없는 경우
        return bestCombination;
    }

    private static void dfs(int arrows, int depth, int[] lion, int[] apeach) {
        // 모든 점수를 확인했거나 모든 화살을 사용한 경우
        if (depth == 11 || arrows == 0) {
            lion[10] += arrows; // 남은 화살은 0점에 모두 배치
            int difference = calculateDifference(lion, apeach); // 점수 차 계산
            if (difference > maxDifference) { // 점수 차가 최대인 경우 업데이트
                maxDifference = difference;
                bestCombination = lion.clone();
            } else if (difference == maxDifference) { // 점수 차가 동일하면 낮은 점수를 더 많이 맞힌 경우 선택
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] > bestCombination[i]) {
                        bestCombination = lion.clone();
                        break;
                    } else if (lion[i] < bestCombination[i]) break;
                }
            }
            lion[10] -= arrows; // 남은 화살 초기화
            return;
        }

        // 라이언이 해당 점수를 가져가는 경우
        if (arrows > apeach[depth]) {
            lion[depth] = apeach[depth] + 1; // 해당 점수를 가져가도록 화살 배치
            dfs(arrows - lion[depth], depth + 1, lion, apeach);
            lion[depth] = 0; // 상태 초기화
        }

        // 라이언이 해당 점수를 포기하는 경우
        dfs(arrows, depth + 1, lion, apeach);
    }

    private static int calculateDifference(int[] lion, int[] apeach) {
        int lionScore = 0, apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (lion[i] > apeach[i]) {
                lionScore += 10 - i; // 라이언이 해당 점수를 가져감
            } else if (apeach[i] > 0) {
                apeachScore += 10 - i; // 어피치가 해당 점수를 가져감
            }
        }
        return lionScore - apeachScore;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] result = solution(n, info);
        System.out.println(Arrays.toString(result));
    }
}
