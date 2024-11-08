import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Double firstOperand, secondOperand;
        Scanner scanner = new Scanner(System.in);
        firstOperand = scanner.nextDouble();
        secondOperand = scanner.nextDouble();
        System.out.println(firstOperand / secondOperand);
   }
}