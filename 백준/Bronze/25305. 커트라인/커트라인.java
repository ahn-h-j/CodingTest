import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] conditionInput = scanner.nextLine().split(" ");
        int N = Integer.parseInt(conditionInput[0]);
        int k = Integer.parseInt(conditionInput[1]);

        String[] scoreInput = scanner.nextLine().split(" ");
        Integer[] score = new Integer[N];

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(scoreInput[i]);
        }

        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(score[k - 1]);
    }
}
