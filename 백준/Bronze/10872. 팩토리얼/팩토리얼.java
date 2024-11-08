import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, sum = 1;
        N = scanner.nextInt();
        for(int i = N; i > 0; i--){
            sum *= i;
        }
        System.out.println(sum);
    }
}