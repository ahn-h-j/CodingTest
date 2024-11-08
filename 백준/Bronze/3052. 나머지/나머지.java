import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int count = 0;
        int[] remain = new int[42];
        Arrays.fill(remain,0);

        for(int i = 0; i < 10; i++){
            input = scanner.nextInt();
            remain[input %= 42]++;
        }
        for(int i = 0; i < 42; i++){
            if(remain[i] != 0){
                count++;
            }
        }
        System.out.println(count);
    }
}