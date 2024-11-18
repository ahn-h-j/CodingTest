import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);

        findGCD(num1, num2);
        findLCM(num1, num2);

    }

    public static void findGCD(int num1, int num2){
        if(num2 == 0){
            System.out.println(num1);
            return;
        }
        findGCD(num2, num1 % num2);
    }

    public static void findLCM(int num1, int num2){
        int num1Count = 1;
        int num2Count = 1;
        int innerNum1 = num1;
        int innerNum2 = num2;
        while(true){
            if(innerNum1 == innerNum2){
                System.out.println(innerNum1);
                return;
            } else if (innerNum1 < innerNum2){
                num1Count++;
                innerNum1 = num1 * num1Count;
            } else{
                num2Count++;
                innerNum2 = num2 * num2Count;
            }

        }
    }
}


