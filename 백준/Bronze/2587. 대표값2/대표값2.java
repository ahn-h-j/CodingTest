import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        System.out.println((int) Arrays.stream(array).average().orElse(0));
        System.out.println(array[2]);

    }
}
