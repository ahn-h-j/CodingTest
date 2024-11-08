import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        long firstOperand, secondOperand, thirdOperand;
        Scanner scanner = new Scanner(System.in);
        firstOperand = scanner.nextLong();
        secondOperand = scanner.nextLong();
        thirdOperand = scanner.nextLong();
        System.out.println(firstOperand + secondOperand + thirdOperand);
   }
}