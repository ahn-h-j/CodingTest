import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] inputA = scanner.nextLine().split(" ");
        int[] arrayA = Arrays.stream(inputA).mapToInt(Integer::parseInt).toArray();
        String[] inputB = scanner.nextLine().split(" ");
        int[] arrayB = Arrays.stream(inputB).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int sum = getSum(N, arrayA, arrayB);
        System.out.println(sum);
    }

    private static int getSum(int N, int[] arrayA, int[] arrayB) {
        int sum = 0;
        for(int index = 0; index < N; index++){
            sum += arrayA[index] * arrayB[N - index - 1];
        }
        return sum;
    }

}
