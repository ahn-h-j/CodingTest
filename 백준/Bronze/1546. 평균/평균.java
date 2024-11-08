import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTest = scanner.nextInt();
        int[] scoreOfTest = new int[numberOfTest];
        int maxScore = 0;
        double sum = 0;

        for(int i = 0; i < numberOfTest; i++){
            scoreOfTest[i] = scanner.nextInt();
            if(maxScore < scoreOfTest[i]){
                maxScore = scoreOfTest[i];
            }
        }
        for(int i = 0; i < numberOfTest; i++){
            sum += (double) scoreOfTest[i] / maxScore * 100;
        }
        System.out.println(sum/numberOfTest);
    }
}
