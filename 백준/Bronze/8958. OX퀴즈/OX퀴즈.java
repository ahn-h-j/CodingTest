import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        String testResult;
        char answerOX;
        int testNumber = 0;
        int questionNumber = 0;
        int totalScore = 0;
        int weightedScore = 1;

        Scanner scanner = new Scanner(System.in);
        testNumber = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testNumber; i++){
            testResult = scanner.nextLine();
            while(true){

                if(questionNumber == testResult.length()){
                    System.out.println(totalScore);
                    questionNumber = 0;
                    totalScore = 0;
                    weightedScore = 1;
                    break;
                }

                answerOX = testResult.charAt(questionNumber);
                if (answerOX == 'O') {
                    totalScore += weightedScore;
                    weightedScore++;
                    questionNumber++;
                }
                else if (answerOX == 'X'){
                    weightedScore = 1;
                    questionNumber++;
                }
            }
        }
   }
}