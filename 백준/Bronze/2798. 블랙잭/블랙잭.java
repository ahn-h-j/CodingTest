import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        //카드 입력
        int[] cards = new int[N];
        String[] inputCards = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(inputCards[i]);
        }

        int result = findIndex(N,M,cards);
        bw.write(result + "");
        bw.flush();

    }
    public static int findIndex(int N,int M, int[] cards) {
        int temp = 0;
        int diff = M + 1;
        int sum = 0;
        for(int outerIndex = 0; outerIndex < N - 2; outerIndex++) {
            for(int intermediateIndex = outerIndex + 1; intermediateIndex < N - 1; intermediateIndex++) {
                for(int innerIndex = intermediateIndex + 1; innerIndex < N; innerIndex++) {
                    temp = cards[outerIndex] + cards[intermediateIndex] + cards[innerIndex];
                    if(temp == M){
                        return temp;
                    } else if(temp < M){
                        if(Math.abs(M - temp) < diff){
                            diff = Math.abs(M - temp);
                            sum = temp;
                        }
                    }
                }
            }
        }
        return sum;
    }
}


