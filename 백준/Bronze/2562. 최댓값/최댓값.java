import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int count = 0;
        int maxCount = 0;
        int max = 0;
        int num;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            num = scanner.nextInt();
            count++;
            if(max < num){
                max = num;
                maxCount = count;
            }
        }
        System.out.println(max);
        System.out.println(maxCount);
    }
}