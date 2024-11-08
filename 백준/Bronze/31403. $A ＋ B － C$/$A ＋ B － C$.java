import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        int c = Integer.parseInt(br.readLine());

        bw.write(""+ (Integer.parseInt(a) + Integer.parseInt(b) - c)+"\n");

        int temp = Integer.parseInt(a+b);
        bw.write("" + (temp - c));
        bw.flush();
    }
}
