import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        int temp;
        int max = 0;
        int maxNum = 0;
        boolean isSame = false;
        int[] textCount = new int[52];

        text = scanner.nextLine();
        for(int i = 0; i < text.length(); i++){
            temp = text.charAt(i);
            if(temp < 97){
                textCount[temp - 'A']++;
            }
            else{
                textCount[temp - 'a']++;
            }
        }
        for(int i = 0; i < 52; i++){
            if(max != 0 && max == textCount[i]){
                isSame = true;
            }
            if(max < textCount[i]){
                isSame = false;
                max = textCount[i];
                maxNum = i;
            }
        }
        if(isSame){
            System.out.println("?");
        }
        else{
            System.out.printf("%c", maxNum + 65);
        }
    }
}