import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int big, small,count;
        big = N / 5;
        count = big;
        small = (N - 5 * big) / 3;
        for(int i = 0; i <= count; i++){
            if(big * 5 + small * 3 == N){
                System.out.println(big + small);
                break;
            }
            else{
                big--;
                small += 2;
                if(big == -1){
                    System.out.println(-1);
                }
            }
        }
    }
}
