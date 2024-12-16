import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        //M ~ N
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] isPrimes = new boolean[N + 1];

        for(int index = 2; index <= N; index++){
            isPrimes[index] = true;
        }

        int border = (int) Math.sqrt(N);

        for(int outerIndex = 2; outerIndex <= border; outerIndex++){
            if(isPrimes[outerIndex]){
                for(int innerIndex = outerIndex * outerIndex; innerIndex <= N; innerIndex += outerIndex){
                    isPrimes[innerIndex] = false;
                }
            }
        }
        for(int index = M; index <= N; index++){
            if(isPrimes[index]){
                System.out.println(index);
            }
        }
    }
}

