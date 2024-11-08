import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String sentence;
        char target;

        int[] alphabet = new int[26];
        Arrays.fill(alphabet,-1);

        sentence = scanner.nextLine();
        for(int i = 0; i < sentence.length(); i++){
            target = sentence.charAt(i);
            if(alphabet[target-97] == -1){
                alphabet[target-97] = i;
            }
        }
        for(int i = 0; i < 26; i++){
            System.out.print(alphabet[i] + " ");
        }
   }
}