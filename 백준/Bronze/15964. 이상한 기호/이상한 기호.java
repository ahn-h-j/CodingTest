import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A, B;
        A = scanner.nextLong();
        B = scanner.nextLong();
        System.out.println((A + B) * (A - B));
    }
}