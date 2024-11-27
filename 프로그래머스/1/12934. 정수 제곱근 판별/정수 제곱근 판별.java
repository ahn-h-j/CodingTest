class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        if(n == (sqrt * sqrt)){
            sqrt += 1;
            sqrt *= sqrt;
            answer = sqrt;
        }
        else{
            answer = -1;
        }
        return answer;
    }
}