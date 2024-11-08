import java.util.Scanner;

import static java.lang.Math.*;

public class Main{
    static boolean judge = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, length;
        N = scanner.nextInt();
        length = (int)log10(N) +1;

        if(N - length*9 < 0){
            for(int i = (int)pow(10,length-1); i < N; i++){
                if(!judge)
                    searchGenerator(N, length, i);
            }
        }
        else{
            for(int i = N - length * 9; i < N; i++){
                if(!judge)
                    searchGenerator(N, length, i);
            }
        }
        if(!judge){
            System.out.println(0);
        }
    }
    public static void searchGenerator(int N, int length, int testNum){
        int sum = 0;
        int origin = testNum;
        int digitNum;
        for(int j = 0; j < length; j++){
            digitNum = testNum % 10;
            testNum /= 10;
            sum += digitNum;
        }
        if(N == origin+sum){
            judge = true;
            System.out.println(origin);
        }
    }
}
