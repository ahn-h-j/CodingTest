import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] attendance = new int[31];
        Arrays.fill(attendance,0);
        for(int i = 0; i < 28; i++){
            attendance[scanner.nextInt()]++;
        }
        for(int i = 1; i <= 30; i++){
            if(attendance[i] == 0){
                System.out.println(i);
            }
        }
    }
}
