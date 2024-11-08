import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        String number;
        int total = 0;

        length = scanner.nextInt();
        scanner.nextLine();
        number = scanner.nextLine();

        for(int i = 0; i < length; i++){
            total += number.charAt(i) - '0';
        }
        System.out.println(total);
    }
}