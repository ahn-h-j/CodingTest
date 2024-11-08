import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
        }
        int V = scanner.nextInt();
        for(int i = 0; i < N; i++){
            if(array[i] == V)
                count++;
        }
        System.out.println(count);
    }
}
