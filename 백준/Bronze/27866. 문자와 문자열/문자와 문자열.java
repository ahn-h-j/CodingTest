import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S;
        int i;

        S = scanner.nextLine();
        i = scanner.nextInt();
        System.out.println(S.charAt(i-1));
    }
}