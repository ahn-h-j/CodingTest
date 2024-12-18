class Solution {
    public int solution(int n) {
        long[] dy = new long[n + 1];
        long div =  1000000007;
        dy[2] = 3;

        for(int outerIndex = 4; outerIndex <= n; outerIndex+=2){
            dy[outerIndex] = 3 * dy[outerIndex - 2] + 2;
            for(int innerIndex = outerIndex - 4; innerIndex > 0; innerIndex-=2){
                dy[outerIndex] += 2 * dy[innerIndex];
            }
            dy[outerIndex] %= div;
        }
        return (int)dy[n];
    }
}