import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        char[] changeWords = new char[input.length()];
        for(int index = 0; index < input.length(); index++) {
            if(Character.isUpperCase(input.charAt(index))) {
                changeWords[index] = Character.toLowerCase(input.charAt(index));
            }else{
                changeWords[index] = Character.toUpperCase(input.charAt(index));
            }
        }
        for(char changeWord : changeWords) {
            bw.write(changeWord);
        }
        bw.flush();
    }
}
