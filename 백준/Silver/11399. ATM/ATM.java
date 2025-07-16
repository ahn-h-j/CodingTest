import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine();
        String[] inputs = scanner.nextLine().split(" ");
        int[] usageTime = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(usageTime);
        System.out.println(getSum(numberOfPeople, usageTime));


    }

    private static int getSum(int numberOfPeople, int[] usageTime) {
        int sum = 0;
        int presum = 0;
        for (int index = 0; index < numberOfPeople; index++) {
            presum += usageTime[index];
            sum += presum;
        }
        return sum;
    }
}
