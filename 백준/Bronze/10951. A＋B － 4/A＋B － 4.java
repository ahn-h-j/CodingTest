import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B = 0;

        while(true){
            try {
                A = scanner.nextInt();
            }catch (Exception e){
                break;
            }
            B = scanner.nextInt();
            System.out.println(A + B);
        }
    }
}