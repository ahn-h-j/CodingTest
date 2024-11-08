import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short A,B,C;
        int sum;
        int num;

        A = scanner.nextShort();
        B = scanner.nextShort();
        C = scanner.nextShort();

        sum = A * B * C;
        int[] count = new int[10];
        Arrays.fill(count,0);

        while(true){
            num = sum % 10;
            count[num]++;
            sum /= 10;
            if(sum == 0)
                break;
        }
        
        for(int i = 0; i < 10; i++){
            System.out.println(count[i]);
        }
    }
}