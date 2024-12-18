import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int[] dy = new int[n+1];
        int mod = 1000000007; 

        dy[1] = 1;
        dy[2] = 2;
        for(int index = 3; index <= n; index++){
            dy[index] = (dy[index - 1] + dy[index - 2]) % mod;
        }
        return dy[n];
    }
}