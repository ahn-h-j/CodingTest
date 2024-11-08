import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int[] input = new int[k];
        int index = 0;
        int inputValue;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            if((inputValue = scanner.nextInt())== 0){
                input[--index] = 0;
            } else{
                input[index++] = inputValue;
            }
        }

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

        System.out.println(sum);
    }
}
