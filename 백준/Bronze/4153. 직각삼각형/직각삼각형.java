import java.util.Scanner;

import static java.lang.Math.pow;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line1 = -1, line2 = -1, line3 = -1;
        int hypotenuse,vertical,horizon;
        while(true){
            line1 = scanner.nextInt();
            line2 = scanner.nextInt();
            line3 = scanner.nextInt();
            if(line1 == 0 && line2 == 0 && line3 ==0)
                break;
            hypotenuse = Math.max(line1, Math.max(line2, line3));
            if(hypotenuse == line1){
                vertical = line2;
                horizon = line3;
            }else if(hypotenuse == line2){
                vertical = line1;
                horizon = line3;
            }else{
                vertical = line1;
                horizon = line2;
            }
            if(pow(hypotenuse, 2) == pow(horizon,2) + pow(vertical,2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}