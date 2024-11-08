import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scale = new int[8];
        int noteNumber;
        String judge = " ";
        for(int i = 0; i < 8; i++){
            scale[i] = scanner.nextInt();
        }
        if(scale[0] == 1){
            noteNumber = 2;
            for(int i = 1; i < 8; i++){
                if(scale[i] != noteNumber){
                    judge = "mixed";
                    break;
                }
                noteNumber++;
            }
            if(noteNumber == 9 && judge.equals(" ")){
                judge = "ascending";
            }
        }
        else if(scale[0] == 8){
            noteNumber = 7;
            for(int i = 1; i < 8; i++){
                if(scale[i] != noteNumber){
                    judge = "mixed";
                    break;
                }
                noteNumber--;
            }
            if(noteNumber == 0 && judge.equals(" ")){
                judge = "descending";
            }
        }
        else{
            judge = "mixed";
        }
        System.out.println(judge);
    }
}