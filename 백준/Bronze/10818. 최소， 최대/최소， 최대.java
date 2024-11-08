import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int max = -1000000;
        int min = 1000000;

        num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = scanner.nextInt();
            if(max < nums[i]){
                max = nums[i];
            }
            if(min > nums[i]){
                min = nums[i];
            }
        }
        System.out.println(min +" "+ max);
    }
}

