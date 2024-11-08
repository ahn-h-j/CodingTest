import java.util.Scanner;

import static java.lang.Math.pow;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int uniqueNumber, NumberOfVerifications;
        int sum = 0;

        for(int i = 0; i < 5; i++){
            uniqueNumber = scanner.nextInt();
            sum += pow(uniqueNumber,2);
        }
        System.out.println(NumberOfVerifications = sum % 10);
    }
}