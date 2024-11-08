import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, X;
        int number;
        N = scanner.nextInt();
        X = scanner.nextInt();
        for(int i = 0; i < N; i++){
            number = scanner.nextInt();
            if(number < X)
                System.out.print(number + " ");
        }
    }
}