import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T, caseNum = 0;
        T = scanner.nextInt();
        int[] R = new int[T];
        String[] S = new String[T];
        
        for(int i = 0; i < T; i++) {
            R[i] = scanner.nextInt();
            S[i] = scanner.next();
        }
        
        for(int i = 0; i < S[caseNum].length(); i++){
            for(int j = 0; j < R[caseNum]; j++){
                System.out.print(S[caseNum].charAt(i));
            }
            if((i + 1) == S[caseNum].length() && caseNum + 1 < T){
                i = -1;
                caseNum++;
                System.out.println();
            }
        }
    }
}