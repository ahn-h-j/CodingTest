import java.io.*;
import java.util.*;

class InputString{
    String input;
    int length;
    public InputString(String input, int length){
        this.input = input;
        this.length = length;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<InputString> inputs = new ArrayList<>();

        //입력 받기
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            inputs.add(new InputString(input, input.length()));
            //중복 단어 제거
            for(int j = 0; j < inputs.size() - 1; j++){
                if(inputs.get(j).input.equals(input)){
                    inputs.remove(j);
                }
            }
        }
        Collections.sort(inputs, new Comparator<InputString>() {
            @Override
            public int compare(InputString o1, InputString o2) {
                //같으면 사전 순
                if(o1.length == o2.length){
                    return o1.input.compareTo(o2.input);
                }
                //같지 않으면 길이 순
                return Integer.compare(o1.length, o2.length);
            }
        });
        for(InputString i : inputs){
            bw.write(i.input + "\n");
        }
        bw.flush();
    }
}


