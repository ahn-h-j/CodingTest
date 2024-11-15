import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //중복을 제거하기 위해 hashset사용
        Set<Integer> set = new HashSet<>();
        String[] inputs = br.readLine().split(" ");
        for(String input: inputs){
            set.add(Integer.parseInt(input));
        }

        //index로 접근
        int M = Integer.parseInt(br.readLine());
        String[] inputNums = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(inputNums[i]);
            Search(set, num);
        }
    }
    private static void Search(Set<Integer> set, int num){
        if(set.contains(num)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}


