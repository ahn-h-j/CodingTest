import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long S = scanner.nextLong();
        int sum = 0;
        
        System.out.println(getCount(sum, S));
    }

    private static int getCount(long sum, long S) {
        int i = 1;
        while(true){
            sum += i;
            if(sum > S ){
                return i - 1;
            }else if(sum == S){
                return i;
            }
            i++;
        }
        
    }


}
