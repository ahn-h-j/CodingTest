import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] matrix = new int[N*M];
        for(int i = 0; i < N*M; i++){
            matrix[i] = scanner.nextInt();
        }
        for(int i = 0; i < N*M; i++){
            matrix[i] += scanner.nextInt();
            System.out.print(matrix[i]);
            if((i+1) % M == 0)
                System.out.println();
            else
                System.out.print(" ");
        }

    }
}
